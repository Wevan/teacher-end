package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.util.HtmlToPdf
import org.springframework.beans.factory.annotation.Autowired
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
    fun report() {
        val s = restTemplate.getForObject<String>("http://localhost:8085/demo")
        var file= File("E:/a/kk.html")
        if (!file.exists()){
            val parent = file.parent
            File(parent).apply {
                this.mkdir();
            }
        }

        file.writeText(s!!)

        var down= HtmlToPdf.tomPdf("E:/a/kk.html","E:/a/kk.pdf")
        var msg=""
    }
}