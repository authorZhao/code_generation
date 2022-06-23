package com.git.jbuf.git;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author authorZhao
 * @since 2022-06-18
 */
public class TestJProtoBuf {


    private static final String JAVA_OUT_ARG = "--java_out=";

    public static void main(String[] args) {
        File javaOutPath = new File("E:\\java\\workspace\\space2\\app-backend\\backend-proto\\src\\main\\java");
        javaOutPath = new File("C:\\Users\\Admin\\Desktop\\工作文档\\worknote\\java");
        File protoDir = new File("E:\\project\\cube\\test_proto");
        //protoDir = copy(protoDir);
        //filterFile(protoDir);


        File protoFile = new File(protoDir.getAbsolutePath()+"/activity.proto");
        //MyProtobufIDLProxy.setFormatJavaField(true);
        try {
            MyProtobufIDLProxy.createAll(protoFile,protoDir, javaOutPath);
            System.out.println("create success. input file="+protoFile.getName()+"\toutput path=" + javaOutPath.getAbsolutePath());
        } catch (IOException var5) {
            System.out.println("create failed: " + var5.getMessage());
        }
        System.exit(0);
    }




    @Test
    public void test2(){
        File protoDir = new File("E:\\project\\cube\\proto");
        protoDir = copy(protoDir);
        filterFile(protoDir);
    }

    @Test
    public void test3(){
        List<Integer> bestList = new ArrayList<>();
        int min = bestList.stream().collect(Collectors.summarizingInt(i -> i)).getMin();
        System.out.println("min = " + min);
    }
















    private static void filterFile(File dir) {
        if(dir.isDirectory()){
            Arrays.stream(dir.listFiles()).forEach(TestJProtoBuf::filterFile);
        }else if(dir.getName().endsWith(".proto")){
            try {
                List<String> strings = FileUtils.readLines(dir, StandardCharsets.UTF_8);
                String option_java_package = strings.stream().filter(i -> i.startsWith("option java_package"))
                        .findFirst().orElse(null);
                if(option_java_package!=null){
                    //option java_package = "com.cube.protocol";
                    int start = option_java_package.indexOf("\"");
                    int end = option_java_package.lastIndexOf("\"");
                    String fileName = dir.getName().substring(0, dir.getName().length() - 6);
                    String oldPackage = option_java_package.substring(start,end);
                    option_java_package = "option java_package = "+oldPackage+"."+fileName+"\";";
                    System.out.println(option_java_package);
                    strings.remove(0);
                    strings.add(0,option_java_package);
                    FileUtils.writeLines(dir,strings);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void help() {
        System.out.println(" Usage: java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto");
    }

    private static File copy(File file){
        File dir = new File("E:\\project\\cube\\test_proto");
        copy(file,dir);
        return dir;
    }


    private static void copy(File file,File dir){
        if(file.isDirectory()){
            Arrays.stream(file.listFiles()).forEach(i->copy(i,dir));
        }else if(file.getName().endsWith(".proto")){
            try {
                FileUtils.copyFileToDirectory(file,dir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
