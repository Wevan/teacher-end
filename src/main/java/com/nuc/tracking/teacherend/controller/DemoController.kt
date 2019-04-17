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
            modelAndView.viewName = "demo"
            modelAndView.model["result"]=result
        }else{
            var result=courseClassService.getStudentMesg(id.toLong())
//            println("*******************************************")
//            result.studentAbilityList.forEach {
//                println("AbilityList "+it.name+","+it.ability.percent+"%")
//            }
//            println("*******************************************")
//            result.studentCourseList.forEach { (t, u) ->
//                println("Course is "+u.name+","+u.studentCourse.percent)
//
//                u.studentCourseTargetList.forEach { (ts, u) ->
//                    u.forEach {rr->
//                        println("Course Target is "+rr.name+","+rr.studentCourseTarget.percent)
//                    }
//                }
//                println("------------------------------------------------")
//            }
//            println("*******************************************")
//            result.studentCollegeTargetList.forEach {tem->
//                println("CollegeTarget is "+tem.name+","+tem.studentCollegeTarget.percent)
//            }


            modelAndView.viewName = "student"
            modelAndView.model["result"]=result
        }

        return modelAndView
    }
}