package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.po.entity.ResourceEntity
import com.nuc.tracking.teacherend.repository.FileRepository
import com.nuc.tracking.teacherend.repository.ResourceClassRepository
import com.nuc.tracking.teacherend.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException


@Service
class FileServiceImpl : FileService {

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

