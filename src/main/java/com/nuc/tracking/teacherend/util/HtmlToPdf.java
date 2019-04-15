package com.nuc.tracking.teacherend.util;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileInputStream;


public class HtmlToPdf {
    public static final String FONT = "E:\\a\\NotoSansCJKsc-Regular.otf";	//本地字体路径（百度下载）

    /**
     * HTML转换成pdf
     * @param html html文件路径
     * @param DEST 生成pdf的路径
     * @throws Exception
     */
    public static void tomPdf(String html, String DEST) throws Exception {
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addFont(FONT);
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(595.0F, 842.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();

    }
}
