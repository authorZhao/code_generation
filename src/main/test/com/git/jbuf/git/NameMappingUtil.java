package com.git.jbuf.git;

import com.google.common.base.CaseFormat;

/**
 * @author authorZhao
 * @since 2022-06-18
 */
public class NameMappingUtil {

    public static String mapClassName(String className){
        char c = className.charAt(0);
        String s = String.valueOf(c).toUpperCase() + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, className.substring(1));
        return s;
    }


}
