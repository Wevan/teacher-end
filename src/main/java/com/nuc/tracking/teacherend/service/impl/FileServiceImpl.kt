package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.po.entity.ResourceEntity
import com.nuc.tracking.teacherend.repository.FileRepository
import com.nuc.tracking.teacherend.repository.ResourceClassRepository
import com.nuc.tracking.teacherend.repository.point.CourseTargetRepository
import com.nuc.tracking.teacherend.repository.point.DailyWayRepository
import com.nuc.tracking.teacherend.repository.relation.CourseTarAndKnowledgeRepository
import com.nuc.tracking.teacherend.repository.student.KnowledgeRepository
import com.nuc.tracking.teacherend.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class FileServiceImpl : FileService {

    override fun getTqPercent(courseId: Long, classId: Long): Float {

        var c = Calendar.getInstance()
        c.time = Date(System.currentTimeMillis())


        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0)
        //将分钟至0
        c.set(Calendar.MINUTE, 0)
        //将秒至0
        c.set(Calendar.SECOND, 0)
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0)

        c.set(Calendar.MONTH + 1, 1)

        var atemp = c.timeInMillis
        var test = Date(atemp)
        println("Timestamp $test")

        var resourceList = fileRepository.findByCourseId(courseId)
        var tqPercent = 0f
        resourceList?.forEach {
            println("ResourceId ${it.id},And ClassId $classId")
            var endTime = resourceClassRepository.findByResourceIdAndClassId(it.id, classId)?.endTime
            println("endtime $endTime")
            if (endTime === null) {
                endTime = 0
                println("nulllllll")
            }
            if (endTime < atemp) {
                tqPercent += it.tq_percent
                println("item ${it.tq_percent},sum $tqPercent")
            }
        }
        return tqPercent
    }

    override fun playTimes(resourceId: Long) {
        var item: ResourceDirctoryFile = fileRepository.findById(resourceId).get()
        item.playTimes += 1
        println("$resourceId PlayTimes update ${item.name},${item.playTimes}")
        fileRepository.save(item)
    }

    @Autowired
    private lateinit var fileRepository: FileRepository
    @Autowired
    private lateinit var resourceClassRepository: ResourceClassRepository
    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository
    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository
    @Autowired
    private lateinit var courseTarAndKnowledgeRepository: CourseTarAndKnowledgeRepository
    @Autowired
    private lateinit var courseTargetRepository: CourseTargetRepository

    override fun deleteById(id: Long) {
        fileRepository.deleteById(id)
    }

    override fun findOne(id: Long): ResourceDirctoryFile {
        return fileRepository.findById(id).get()
    }

    override fun findAll(courseId: Long, classId: Long): List<ResourceEntity>? {
        var fileList = fileRepository.findByCourseId(courseId)
        var resultList = ArrayList<ResourceEntity>()
        fileList?.map {
            var ent = resourceClassRepository.findByResourceIdAndClassId(it.id, classId)
            var resourceEntity = ResourceEntity()
            if (ent !== null) {
                resourceEntity.resourceClass = ent
            }
            resourceEntity.resourceDirctoryFile = it
            resultList.add(resourceEntity)
            return@map
        }

        return resultList
    }

    @Throws(Exception::class)
    override fun saveAllFile(resourceList: List<ResourceDirctoryFile>, type: Long, knowledgeId: Long): Boolean {

//        自动计算各部分平均百分比，需先查出所有的再做除法
        if (type == 0L) {
            var tempList = fileRepository.findByKnowledgeIdAndType(knowledgeId, type)
            var list = ArrayList<ResourceDirctoryFile>()
            if (tempList != null) {
                list.addAll(tempList)
            }
            list.addAll(resourceList)
            val len = list.size
            list.forEach {
                it.percent = 1.0f / len
                println("Resource List ite ${it.name},${it.url},${it.percent},${it.type}")
            }
            /**
             * 在存储资源时候计算 完成它以后 会增长的课程达成度
             * tq_percent == 资源自身percent * 资源考核方式的percent *
             *  * 对应知识点所占percent*（多个）对应的课标与该知识点的percent
             *  * 课标自身percent 进行累加
             */
            list.forEach {
                //到课程目标之前的percent乘积
                var tempPercent = it.percent * dailyWayRepository.findDailyWayByCourseIdAndType(it.courseId, "1").percent *
                        knowledgeRepository.findById(it.knowledgeId).get().percent
                println("process is ${it.percent} * ${dailyWayRepository.findDailyWayByCourseIdAndType(it.courseId, "1").percent}*" +
                        " ${knowledgeRepository.findById(it.knowledgeId).get().percent}=$tempPercent")
                // 知识点占各个课标的百分比
                var courseTargetList = courseTarAndKnowledgeRepository.findAllByCourseId(it.courseId)
                var tempPercent2 = 0f
                var tempSum = 0f
                courseTargetList.forEach { item ->
                    tempPercent2 = tempPercent * item.percent * courseTargetRepository.findById(item.courseTargetId).get().percent
                    println("process2 is ${tempPercent} * ${item.percent} * ${courseTargetRepository.findById(item.courseTargetId).get().percent}=$tempPercent2")
                    tempSum += tempPercent2
                    println("process3 is ${tempPercent2}+= ${tempSum}")
                }
                it.tq_percent = tempSum
                println("Tempsum is ${it.tq_percent},courseId is ${it.courseId},knowledgeId is ${it.knowledgeId}")
            }

            fileRepository.saveAll(list)
        } else {
            //普通资源只需要直接存储即可
            resourceList.forEach {
                println("else case ${it.name},${it.url},${it.percent},${it.type}")
            }
            fileRepository.saveAll(resourceList)
        }
        return true
    }
}
//
//fun main(args: Array<String>) {
//    var c = Calendar.getInstance()
//    c.time = Date(System.currentTimeMillis())
//
//    c.set(Calendar.DAY_OF_MONTH, 1);
//    //将小时至0
//    c.set(Calendar.HOUR_OF_DAY, 0);
//    //将分钟至0
//    c.set(Calendar.MINUTE, 0);
//    //将秒至0
//    c.set(Calendar.SECOND, 0);
//    //将毫秒至0
//    c.set(Calendar.MILLISECOND, 0);
//
//    c.set(Calendar.DAY_OF_MONTH + 1, 1)
//    var atemp = c.timeInMillis
//
//    var test = Date(atemp)
//
//    println("Date is ${test.month} - ${test.day},$test , "+Date(System.currentTimeMillis()))
//}
