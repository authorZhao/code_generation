package com.git.proto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author authorZhao
 * @since 2022-06-16
 */
@Data
@Accessors(chain = true)
public class InMethod {
    private String fieldName;
    private String fieldType;
    private Class fieldRealType;
}
