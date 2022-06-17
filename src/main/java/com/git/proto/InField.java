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
public class InField {

    private String name;

    private Class realType;

    /**
     * String，Integer 等
     */
    private String javaType;


}
