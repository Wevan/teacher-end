package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.entity.ResourceClass
import com.nuc.tracking.teacherend.service.ResourceClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/resourceClass")
class ResourceServiceController {
    @Autowired
    private lateinit var resourceClassService: ResourceClassService

    @PostMapping("/insert")
    fun insert(@RequestBody resourceClass: ResourceClass) {
        resourceClassService.saveOne(resourceClass)
    }
}