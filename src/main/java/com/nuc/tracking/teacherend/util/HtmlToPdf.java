package com.nuc.tracking.teacherend.util;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class HtmlToPdf {
    /**
     * HTML转换成pdf
     * @param html html文件路径
     * @param DEST 生成pdf的路径
     * @throws Exception
     */
    public static void tomPdf(String html, String DEST) throws Exception {
        Resource resource =new ClassPathResource("NotoSansCJKsc-Regular.otf");
        InputStream is = resource.getInputStream();
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addFont(input2byte(is));
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(595.0F, 842.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();

    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}
