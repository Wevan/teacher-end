package com.nuc.tracking.teacherend.util

import com.hankcs.hanlp.HanLP
import com.hankcs.hanlp.mining.word2vec.WordVectorModel

/**
 * @author 杨晓辉 2019/6/3 15:28
 */
object NLPUtils {

    lateinit var wordVectorModel: WordVectorModel

    /**
     * 加载文本
     */
    init {
        // "C:\Users\young\Desktop\polyglot-zh.txt
        wordVectorModel = WordVectorModel("C:/Users/43886/Desktop/polyglot-zh.txt")

    }


    /**
     * 关键字提取
     * @param content String
     * @return List<String>
     */
    fun getKeyWords(content: String, size: Int): List<String> {
        return HanLP.extractKeyword(content, size)
    }


    /**
     * 文本相似度计算
     * @param what String
     * @param with String
     * @return Float
     */
    fun wordSimilarity(what: String, with: String): Float {
        return wordVectorModel.similarity(what, with)
    }
}