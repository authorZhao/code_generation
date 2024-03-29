package com.git.proto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * @author authorZhao
 * @since 2022-06-14
 */
@Data
@Accessors(chain = true)
public class InClass {
    private String name;
    private String type;
    private Class clazz;
    private Set<InField> inFieldSet;
    private Boolean isEnum;
}
