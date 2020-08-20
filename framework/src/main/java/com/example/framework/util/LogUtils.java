package com.example.framework.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.framework.BuildConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {

    private static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void i(String text) {
        if (BuildConfig.LOG_DEBUG) {
            if (!TextUtils.isEmpty(text)) {
                Log.i(BuildConfig.LOG_TAG, text);
                writeToFile(text);
            }
        }
    }

    public static void e(String text) {
        if (BuildConfig.LOG_DEBUG) {
            if (!TextUtils.isEmpty(text)) {
                Log.e(BuildConfig.LOG_TAG, text);
                writeToFile(text);
            }
        }
    }

    public static void writeToFile(String text){
        String fileName = "/sdcard/Meet/Meet.log";
        String log = mSimpleDateFormat.format(new Date()) + " " + text;
        File folder = new File("/sdcard/Meet/");
        if (!folder.exists()){
            folder.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        BufferedWriter writer = null;
        try{
            fileOutputStream = new FileOutputStream(fileName, true);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Charset.forName("gbk")));
            writer.write(log);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
