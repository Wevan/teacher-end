package com.nuc.tracking.teacherend.controller

import com.google.common.collect.Maps
import com.nuc.tracking.teacherend.util.HtmlToPdf
import com.nuc.tracking.teacherend.util.PathUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.io.File

@RestController
@RequestMapping("/report")
class ReportController {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @GetMapping("/file")
    fun report(@RequestParam id: String, @RequestParam type: String, @RequestParam courseId: String) {
        var url = "http://localhost:8085/demo?id=$id&type=$type&courseId=$courseId"
        val s = restTemplate.getForObject<String>(url)
        var filePath=PathUtils.rootPath()+"/tracking/$id.html"
        println("ReportController file path $filePath")
        var file = File(filePath)
        if (!file.exists()) {
            val parent = file.parent
            println("File Parent is $parent")
            File(parent).apply {
                this.mkdir()
            }
        }
        file.writeText(s!!)
        var downPath=PathUtils.rootPath()+"/tracking/$id.pdf"
        HtmlToPdf.tomPdf(filePath, downPath)
    }

    @GetMapping("/down")
    fun down(@RequestParam id: String): ResponseEntity<InputStreamResource>{
        var filePath=PathUtils.rootPath()+"/tracking/$id.pdf"
        val fileDown = FileSystemResource(filePath)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fileDown.filename))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(fileDown.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(InputStreamResource(fileDown.inputStream))
    }

}