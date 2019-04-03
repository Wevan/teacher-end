package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.Excel
import com.nuc.tracking.teacherend.repository.ExcelRepository
import com.nuc.tracking.teacherend.service.ExcelService
import org.apache.poi.ss.usermodel.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

import java.util.ArrayList


@Service
class ExcelServiceImpl : ExcelService {

    @Autowired
    private lateinit var excelRepository: ExcelRepository

    @Throws(Exception::class)
    override fun getExcel(file: MultipartFile): Boolean {
        val list = ArrayList<Excel>()

        //1.得到上传的表
        val workbook2 = WorkbookFactory.create(file.inputStream)
        //2、获取test工作表
        val sheet2 = workbook2.getSheet("sheet")
        //获取表的总行数
        val num = sheet2.lastRowNum
        //System.out.println(num);
        //总列数
        val col = sheet2.getRow(0).lastCellNum.toInt()


        //遍历excel每一行
        for (j in 0..num) {
            val row1 = sheet2.getRow(j)

            //如果单元格中有数字或者其他格式的数据，则调用setCellType()转换为string类型
            val cell1 = row1.getCell(0)
            cell1.setCellType(CellType.STRING)
            //获取表中第i行，第2列的单元格
            val cell2 = row1.getCell(1)
            //excel表的第i行，第3列的单元格
            val cell3 = row1.getCell(2)
            cell3.setCellType(CellType.STRING)
            val cell4 = row1.getCell(3)
            val cell5 = row1.getCell(4)

            //这里new 一个对象，用来装填从页面上传的Excel数据，字段根据上传的excel决定
            val excel = Excel()

            excel.id = cell1.stringCellValue
            excel.email=cell2.stringCellValue
            excel.password=cell3.stringCellValue
            excel.role=cell4.stringCellValue
            excel.username=cell5.stringCellValue
            list.add(excel)
        }

        excelRepository.saveAll(list)
        return true
    }

}
