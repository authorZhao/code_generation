package com.git;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.git.util.CmdUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author authorZhao
 * @since 2022-06-18
 */
public class TestJProtoBuf {


    @Test
    public void testParseProto(){
        //
        String path = "--java_out=E:/idea/workspace3/gan/app-backend/backend-proto/src/main/java";
        String[] cmd = {"cmd.exe",
                "/C",
                "E:/java/jdk17/bin/java.exe -jar",
                "E:/idea/workspace3/gan/tool/jprotobuf-2.4.9-jar-with-dependencies.jar",
                "--java_out=E:/idea/workspace3/gan/tool/java",
                "E:/idea/workspace3/gan/proto/"};
        cmd[4] = path;
        File file = new File("E:/idea/workspace3/gan/proto/");
        doGen(file,cmd);

    }

    private void doGen(File file, String[] cmd) {
        String[] newCmd = Arrays.copyOf(cmd, 6);
        if(file.isDirectory()){
            Arrays.stream(file.listFiles()).forEach(i->doGen(i,newCmd));
        }else {
            if(file.isFile() && file.getName().endsWith(".proto")){
                newCmd[5] = newCmd[5]+file.getName();
                String exec = CmdUtil.exec(newCmd);
                System.out.println("exec = " + exec);
                /*try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    private static final String JAVA_OUT_ARG = "--java_out=";

    public static void main(String[] args) {
        File currentPath = new File(".");
        if (args == null || args.length < 1) {
            help();
            System.exit(-1);
        }

        File javaOutPath = null;
        File protoPath = null;
        if (args.length > 1) {
            if (args[0].startsWith("--java_out=")) {
                javaOutPath = new File(StringUtils.removeStart(args[0], "--java_out="));
            }

            protoPath = new File(args[1]);
        } else {
            javaOutPath = currentPath;
            protoPath = new File(args[0]);
        }

        if (!protoPath.exists()) {
            System.out.println("proto file not found at " + protoPath.getAbsolutePath());
            System.exit(-1);
        }

        ProtobufIDLProxy.setFormatJavaField(true);

        try {
            ProtobufIDLProxy.generateSource(protoPath, javaOutPath);
            System.out.println("create success. output path=" + javaOutPath.getAbsolutePath());
        } catch (IOException var5) {
            System.out.println("create failed: " + var5.getMessage());
        }

        System.exit(0);
    }

    private static void help() {
        System.out.println(" Usage: java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto");
    }
}

