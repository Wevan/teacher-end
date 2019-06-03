package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.repository.point.ResourceLogRepository
import com.nuc.tracking.teacherend.repository.point.ResourceRepository
import com.nuc.tracking.teacherend.service.RecommendService
import com.nuc.tracking.teacherend.util.NLPUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author wevan 2019/6/3 9:49
 */
@Service
class RecommendServiceImpl : RecommendService {

    @Autowired
    private lateinit var resourceLogRepository: ResourceLogRepository

    @Autowired
    private lateinit var resourceRepository: ResourceRepository


    /**
     * 生成资源推荐
     */
    @Transactional
    override fun generateRecommend(studentId: Long) {
        // 七天毫秒数
        val sevenDay = 1000 * 60 * 60 * 24 * 7
        val resourceLogs = resourceLogRepository.findByStudentId(studentId)
        // 资源集合 获取七天内的资源
        val resourceList = resourceLogs.filter {
            it.time.time + sevenDay >= System.currentTimeMillis()
        }.map { resourceLog ->

            println("resourceLog = ${resourceLog}")

            val resource = resourceRepository.findById(resourceLog.id).get()
            return@map resource
        }
        //  获取名字相似的资源
        val nameLikeResourceList = resourceList.map { resourceDirctoryFile ->

            val keyWords = NLPUtils.getKeyWords(resourceDirctoryFile.name.toString(), 2)

            val resourceDirctoryFileList = keyWords.map {
                return@map "%$it%"
            }.map { name ->
                resourceRepository.findByNameLike(name)
            }.flatten()

            return@map resourceDirctoryFileList
        }.flatten()

        val set = HashSet<ResourceDirctoryFile>()
        set.addAll(nameLikeResourceList)

        set.map {
            println("it.id = ${it.id}")
        }
        // 计算相似度 ？
        set.map {

        }
        // 名字相似 * 0.6 + 播放量 * 0.4

    }
}