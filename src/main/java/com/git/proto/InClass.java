package com.git.proto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author authorZhao
 * @since 2022-06-14
 */
@Data
@Accessors(chain = true)
public class InClass {
    private String name;
    private String type;
}
