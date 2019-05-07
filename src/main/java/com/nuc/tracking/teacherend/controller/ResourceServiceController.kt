package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.entity.ResourceClass
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.ResourceClassService
import com.nuc.tracking.teacherend.util.ResultUtils
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

    @PostMapping("/insertList")
    fun insertAll(@RequestBody resourceClassList: List<ResourceClass>) {
        resourceClassService.saveAll(resourceClassList)
    }

}