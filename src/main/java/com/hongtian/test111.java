package com.hongtian;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.UUID;

/**
 * @author weed
 * @date 2021/1/12 0012 15:35
 * @description
 */
public class test111 {
    public static void writeText(String filePath, String content,boolean isAppend) {
        FileOutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = new FileOutputStream(filePath,isAppend);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
                if (outputStreamWriter != null){
                    outputStreamWriter.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        HashSet<String> objects = new HashSet<>();
        while(true){
            String s = UUID.randomUUID().toString();
            boolean add = objects.add(s);
            if(!add){
                System.out.println("重复："+s);
            }
        }
    }
}
