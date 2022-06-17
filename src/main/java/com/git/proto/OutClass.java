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

    private String allName;

    private List<InClass> innerClassList;

    private Class clazz;

    public static String getOutName(String className){
        int indexOf = className.lastIndexOf(".")+1;
        return className.substring(indexOf,className.length()-5)+"DTO";
    }

    /**
     * 获取类全名
     * @param className
     * @return
     */
    public static String getAllOutName(String className){
        return className.substring(0,className.length()-5)+"DTO";
    }


}
