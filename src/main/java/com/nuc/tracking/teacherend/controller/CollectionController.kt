package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.entity.UserCollection
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.CollectionService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 资源收藏
 */

@RestController
@RequestMapping("/collection")
class CollectionController {
    @Autowired
    private lateinit var collectionService: CollectionService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollection(@RequestBody collection: UserCollection): Result {
        val msg = collectionService.save(collection)
        return ResultUtils.success(200, "收藏成功", msg)
    }

    @DeleteMapping("/delete")
    fun deleteOne(id: Long): Result {
        val msg = collectionService.deleteById(id)
        println("Id ios $id")
        return ResultUtils.success(200, "删除成功", msg)
    }

    @GetMapping("/findAll")
    fun findAll(userId: Long): Result {
        val msg = collectionService.findAllById(userId)
        return ResultUtils.success(200, "查找成功", msg)
    }
}