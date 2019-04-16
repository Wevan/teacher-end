package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.service.CourseClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class DemoController {

    @Autowired
    private lateinit var courseClassService: CourseClassService

    @RequestMapping("demo")
    fun getDemo(modelAndView: ModelAndView, @RequestParam id: String, @RequestParam type: String, @RequestParam courseId: String): ModelAndView {
        println("DemoController param: id $id, type $type,courseId $courseId")
        modelAndView.viewName = "demo"
        modelAndView.model["id"] = id
        modelAndView.model["type"] = type

        /**
         * @param type 访问类型
         * 1为教师
         * 2为学生
         */
        if (type == "1") {
            var result=courseClassService.getCourseMesg(id.toLong(), courseId.toLong())
//            result.forEach{it->
//                it.forEach { (t, u) ->
//                    u.forEach {item->
//                        println("Msg "+item.name+","+item.studentCourse.percent+","+item.studentCourse.studentId)
//                    }
//                }
//            }
            modelAndView.model["result"]=result
        }

        return modelAndView
    }
}