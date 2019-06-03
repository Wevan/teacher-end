package com.nuc.tracking.teacherend.util

import com.hankcs.hanlp.HanLP

/**
 * @author 杨晓辉 2019/6/3 15:28
 */
object NLPUtils {

    /**
     * 关键字提取
     * @param content String
     * @return List<String>
     */
    fun getKeyWords(content: String, size: Int): List<String> {
        return HanLP.extractKeyword(content, size)
    }
}