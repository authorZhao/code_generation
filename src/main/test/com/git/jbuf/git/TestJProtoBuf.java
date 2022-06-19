package com.git.jbuf.git;

import java.io.File;
import java.io.IOException;

/**
 * @author authorZhao
 * @since 2022-06-18
 */
public class TestJProtoBuf {


    private static final String JAVA_OUT_ARG = "--java_out=";

    public static void main(String[] args) {
        File javaOutPath = new File("E:\\idea\\workspace3\\gan\\tool\\java");

        File protoDir = new File("E:/idea/workspace3/gan/proto");

        File protoFile = new File("E:/idea/workspace3/gan/proto/activity.proto");
        MyProtobufIDLProxy.setFormatJavaField(true);
        try {
            MyProtobufIDLProxy.createAll(protoFile,protoDir, javaOutPath);
            System.out.println("create success. input file="+protoFile.getName()+"\toutput path=" + javaOutPath.getAbsolutePath());
        } catch (IOException var5) {
            System.out.println("create failed: " + var5.getMessage());
        }
        System.exit(0);
    }

    private static void help() {
        System.out.println(" Usage: java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto");
    }
}
