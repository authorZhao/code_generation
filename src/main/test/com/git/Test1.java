package com.git;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author authorZhao
 * @since 2022-05-31
 */
public class Test1 {

    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("change_cup",10);
        Integer change_cup = Optional.ofNullable(map).map(j -> j.get("change_cup")).map(Object::toString).map(Integer::valueOf)
                .orElse(0);
        System.out.println("change_cup = " + change_cup);
    }
}
