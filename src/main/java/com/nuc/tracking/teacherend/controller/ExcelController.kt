package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.CourseService
import com.nuc.tracking.teacherend.service.ExcelService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.multipart.MultipartFile


@Controller
@RequestMapping("/upload")
class ExcelController {

    @Autowired
    private lateinit var excelService: ExcelService

    @Autowired
    private lateinit var courseService: CourseService

    @RequestMapping(value = "/excel", method = [RequestMethod.POST])
    fun upload(@RequestBody file: MultipartFile): Result {
        val flag = excelService.getExcel(file)

        return ResultUtils.success(200,"save success")
    }


}
