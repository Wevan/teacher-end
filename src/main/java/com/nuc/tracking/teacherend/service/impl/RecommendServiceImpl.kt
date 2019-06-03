package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.repository.point.ResourceLogRepository
import com.nuc.tracking.teacherend.repository.point.ResourceRepository
import com.nuc.tracking.teacherend.service.RecommendService
import com.nuc.tracking.teacherend.util.NLPUtils
import com.nuc.tracking.teacherend.vo.RecommendResource
import org.springframework.beans.BeanUtils
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
    override fun generateRecommend(studentId: Long): HashSet<RecommendResource> {
        // 七天毫秒数
        val sevenDay = 1000 * 60 * 60 * 24 * 7
        val resourceLogs = resourceLogRepository.findByStudentId(studentId)
        // 资源集合 获取七天内的资源
        val resourceList = resourceLogs.filter {
            it.time.time + sevenDay >= System.currentTimeMillis()
        }.map { resourceLog ->
            val resource = resourceRepository.findById(resourceLog.id).get()
            return@map resource
        }
        //  获取名字相似的资源
        val recommendResourceList = resourceList.map { resourceDirctoryFile ->

            val keyWords = NLPUtils.getKeyWords(resourceDirctoryFile.name.toString(), 2)

            val resourceDirctoryFileList = keyWords.map { word ->
                return@map "%$word%"
            }.map { name ->
                // 0 为视频
                resourceRepository.findByNameLikeAndType(name, type = 0L)
            }.flatten().map {
                val wordSimilarity = NLPUtils.wordSimilarity(resourceDirctoryFile.name!!, it.name!!)
                val recommendResource = RecommendResource()
                BeanUtils.copyProperties(it, recommendResource)
                // 相似度 * 0.6 + 播放量 * 0.4
                val rankScore = wordSimilarity * 0.6 + it.playTimes * 0.4
                recommendResource.rankScore = rankScore.toFloat()
                recommendResource
            }
            return@map resourceDirctoryFileList
        }.flatten().sortedByDescending {
            it.rankScore
        }

        val resourceSet = HashSet<RecommendResource>()
        resourceSet.addAll(recommendResourceList)
        return resourceSet


    }
}