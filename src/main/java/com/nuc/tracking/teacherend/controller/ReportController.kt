package com.nuc.tracking.teacherend.controller

import com.google.common.collect.Maps
import com.nuc.tracking.teacherend.util.HtmlToPdf
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
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
    fun report() : ResponseEntity<InputStreamResource>{
//        var url = "http://localhost:8085/demo?id=1713010101&type=2&courseId=9"
//        val s = restTemplate.getForObject<String>(url)
//        var file = File("E:/a/s.html")
//        if (!file.exists()) {
//            val parent = file.parent
//            File(parent).apply {
//                this.mkdir()
//            }
//        }
//
//        file.writeText(s!!)
//
//        var down = HtmlToPdf.tomPdf("E:/a/s.html", "E:/a/s.pdf")
        var filePath="E:/a/s.pdf"
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