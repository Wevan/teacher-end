package com.nuc.tracking.teacherend.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class DemoController {

    @RequestMapping("demo")
    fun getDemo(modelAndView: ModelAndView): ModelAndView {
        modelAndView.viewName="demo"
        modelAndView.model["test"]="e"
        return modelAndView
    }
}