package com.nuc.tracking.teacherend.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownPage {
    public static void down() throws IOException {
        InputStream inputStream;//接收字节输入流
        InputStreamReader inputStreamReader;//将字节输入流转换成字符输入流
        BufferedReader bufferedReader;//为字符输入流加缓冲
        FileOutputStream fileOutputStream;//字节输出流
        OutputStreamWriter outputStreamWriter;//将字节输出流转换成字符输出流

        URL wangyi = new URL("http://localhost:8085/demo");
        inputStream = wangyi.openStream();
        inputStreamReader = new InputStreamReader(inputStream, "gb2312");
        bufferedReader = new BufferedReader(inputStreamReader);
        String s;
        File dest = new File("E:/kk.html");
        fileOutputStream = new FileOutputStream(dest);
        outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gb2312");
        while ((s = bufferedReader.readLine()) != null) {
            outputStreamWriter.write(s);
        }

        outputStreamWriter.close();
        fileOutputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
