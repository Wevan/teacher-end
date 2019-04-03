package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.repository.FileRepository
import com.nuc.tracking.teacherend.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException


@Service
class FileServiceImpl : FileService {


    override fun deleteById(id: Long) {
        fileRepository.deleteById(id)
    }

    override fun findOne(id: Long): ResourceDirctoryFile {
        return fileRepository.findById(id).get()
    }

    override fun findAll(): List<ResourceDirctoryFile> {
        return fileRepository.findAll()
    }

    @Autowired
    private lateinit var fileRepository: FileRepository

    @Throws(Exception::class)
    override fun getFile(resourceDirctoryFile: ResourceDirctoryFile, file: MultipartFile): Boolean {

        try {
            if (file.isEmpty) {
                return false
            }
            // 获取文件名
            val fileName = file.originalFilename
            println("上传的文件名为：$fileName")
            // 获取文件的后缀名
            val suffixName = fileName.substring(fileName.lastIndexOf("."))
            println("文件的后缀名为：$suffixName")
            // 设置文件存储路径
            val docPath: String
            val os = System.getProperty("os.name")
            docPath = if (os.contains("Windows")) {
                "F:\\SX\\resource\\manager\\kj\\"
            } else {
                "~\\data\\resource\\manager\\kj\\"
            }
            val path = docPath + fileName
            val dest = File(path)
//            // 检测是否存在目录
            if (!dest.parentFile.exists()) {
                dest.parentFile.mkdirs()
            }
            file.transferTo(dest)// 文件写入
            resourceDirctoryFile.name = fileName
            resourceDirctoryFile.url = path
            fileRepository.save(resourceDirctoryFile)
            return true
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }
}

