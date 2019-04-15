package com.nuc.tracking.teacherend.util

import com.itextpdf.html2pdf.HtmlConverter
import com.itextpdf.io.font.FontConstants
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfPage
import com.nuc.tracking.teacherend.result.Result
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.canvas.PdfCanvas
import com.itextpdf.layout.Document
import java.io.*
import java.net.URL


/**
 * @author 杨晓辉 2018/2/1 14:07
 * ResultUtils 通过该类进行结果返回，保证了接口风格统一
 */
object ResultUtils {

    private var result = Result()

    /**
     * 返回结果成功
     * @param code 返回状态码，默认为 200 表示成功
     * @param message 状态信息，默认为成功
     * @param data 返回数据，默认为 `null`
     *
     */
    fun success(code: Int = 200, message: String = "成功", data: Any? = null): Result {
        result.code = code
        result.message = message
        result.data = data
        return result
    }

    /**
     * 返回错误信息
     * @param code 错误状态码
     * @param message 错误信息
     */
    fun error(code: Int, message: String): Result {
        result.code = code
        result.message = message
        result.data = null
        return result
    }
}

fun main(args: Array<String>) {
//    var pdf: PdfDocument = PdfDocument(PdfWriter("E:\\a.pdf"));
//
//    //Add new page
//    var ps:PageSize  = PageSize.A4;
//    var page:PdfPage  = pdf.addNewPage(ps);
//
//    var canvas: PdfCanvas = PdfCanvas(page);
//
//    var text:MutableList<String> = ArrayList()
//
//    text.add("         Episode V         ");
//    text.add("  THE EMPIRE STRIKES BACK  ");
//    text.add("It is a dark time for the");
//    text.add("Rebellion. Although the Death");
//    text.add("Star has been destroyed,");
//    text.add("Imperial troops have driven the");
//    text.add("Rebel forces from their hidden");
//    text.add("base and pursued them across");
//    text.add("the galaxy.");
//    text.add("Evading the dreaded Imperial");
//    text.add("Starfleet, a group of freedom");
//    text.add("fighters led by Luke Skywalker");
//    text.add("has established a new secret");
//    text.add("base on the remote ice world");
//    text.add("of Hoth...");
//
//    //Replace the origin of the coordinate system to the top left corner
//    canvas.concatMatrix(1.0, 0.0, 0.0, 1.0, 0.0, ps.getHeight().toDouble());
//    canvas.beginText()
//            .setFontAndSize(PdfFontFactory.createFont(FontConstants.COURIER_BOLD), 14.0f)
//            .setLeading(14 * 1.2f)
//            .moveText(70.0, -40.0);
//
//    text.forEach {
//        canvas.newlineShowText(it);
//
//    }
//
////    for (s : text) {
////        //Add text and move to the next line
////        canvas.newlineShowText(s);
////    }
//    canvas.endText();
//
//    //Close document
//    pdf.close();

}