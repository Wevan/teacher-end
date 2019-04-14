package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentGlobalWay
import com.nuc.tracking.teacherend.repository.UserRepository
import com.nuc.tracking.teacherend.repository.point.GlobalWayRepository
import com.nuc.tracking.teacherend.repository.student.StudentGlobalWayRepository
import com.nuc.tracking.teacherend.service.student.StudentGlobalWayService
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.ArrayList

@Service
class StudentGlobalWayServiceImpl : StudentGlobalWayService {
    override fun findOne(id: Long): StudentGlobalWay {
        return studentGlobalWayRepository.findById(id).get()
    }

    @Autowired
    private lateinit var studentGlobalWayRepository: StudentGlobalWayRepository
    @Autowired
    private lateinit var globalWayRepository: GlobalWayRepository
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun save(file: MultipartFile, courseId: Long, typeTest: String) {

        val list = ArrayList<StudentGlobalWay>()

        val workbook2 = WorkbookFactory.create(file.inputStream)

        val sheet2 = workbook2.getSheet("sheet")

        val num = sheet2.lastRowNum

        for (j in 0..num) {
            val row1 = sheet2.getRow(j)

            //第一个单元格存储的是学号，要根据学号查找到用户号再作为studentId存储
            val cell1 = row1.getCell(0)
            cell1.setCellType(CellType.STRING)
            //第二个单元格为成绩，×0.01后存储
            val cell2 = row1.getCell(1)
            cell2.setCellType(CellType.NUMERIC)

            val studentGlobalWay = StudentGlobalWay()
            studentGlobalWay.courseId = courseId
            studentGlobalWay.globalWayId = globalWayRepository.findByCourseIdAndType(courseId, typeTest).id
            studentGlobalWay.studentId = userRepository.findUserByUsername(cell1.stringCellValue).id
            studentGlobalWay.percent = (0.01 * cell2.numericCellValue).toFloat()
            list.add(studentGlobalWay)
        }
        studentGlobalWayRepository.saveAll(list)
    }
}