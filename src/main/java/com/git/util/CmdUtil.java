package com.git.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author authorZhao
 */
@Slf4j
public class CmdUtil {


    /**
     * 打开目录
     */
    public static void openDir(String path) {
        if (isWin()) {
            exec(new String[]{"cmd.exe", "/C", "explorer "+path});
        }
        log.info("正在打开目录={}", path);
    }

    /**
     * 使用记事本/vscode等打开目录
     */
    public static void openWithCode(String path) {
        String result = "";
        if (isWin()) {
            result = exec(new String[]{"cmd.exe", "/C", "Code " +path});
        }
        log.info("正在使用vs code打开文件={}", result);
    }



    /**
     * 执行命令
     * @param mdCommand 命令
     * @param dir 执行目录
     * @return
     */
    public static String executeCommand(String[] mdCommand,String dir) {
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        BufferedReader bufferedReader = null;
        try {
            if(StringUtils.isNotBlank(dir)){
                process = Runtime.getRuntime().exec(mdCommand,null,new File(dir));
            }else {
                process = Runtime.getRuntime().exec(mdCommand,null);
            }
            bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8.name()));
            String line = null;
            while((line=bufferedReader.readLine()) != null){
                stringBuilder.append(line+"\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(process!=null) {
                process.destroy();
            }
            e.printStackTrace();
            return null;
        }
    }

    public static String exec(String[] mdCommand) {
        return executeCommand(mdCommand,null);
    }

    private static boolean isWin(){
        String systemName = System.getProperty("os.name").toLowerCase();
        if (systemName.startsWith("win")) {
            return true;
        }
        return false;
    }

}
