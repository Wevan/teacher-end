package com.nuc.tracking.teacherend.util
import org.springframework.util.ResourceUtils
import java.io.File

object PathUtils {

    /**
     * 获取项目根路径
     * @return String 根路径
     */
    fun rootPath():String {
        var path = File(ResourceUtils.getURL("classpath:").path)
        if (!path.exists()) {
            path = File("")
        }
        return path.absolutePath
    }
}