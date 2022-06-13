package com.git.proto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author authorZhao
 * @since 2022-06-14
 */
@Data
@Accessors(chain = true)
public class OutClass {

    private String name;

    private List<InClass> innerClassList;

    public static String getOutName(String className){
        int indexOf = className.lastIndexOf(".");
        return className.substring(indexOf,className.length()-5)+"DTO";
    }

    public static String getInName(String outName,String inClassName){
        int indexOf = inClassName.lastIndexOf("$");
        return outName+inClassName.substring(indexOf);
    }


}
