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
        int indexOf = className.lastIndexOf(".")+1;
        return className.substring(indexOf,className.length()-5)+"DTO";
    }

    public static String getInName(String inClassName){
        int indexOf = inClassName.lastIndexOf("$")+1;
        return inClassName.substring(indexOf);
    }

    public static String getFieldName(String name){
        if(name.endsWith("_")){
            return name.substring(0,name.length()-1);
        }
        return name;
    }


}
