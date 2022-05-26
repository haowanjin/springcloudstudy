package com.ddup.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 2020/8/14
 */
public class HashTableTest {
    public static void main(String[] args) {
        Map<String, Integer> m = new Hashtable<>();
        Map<String, Integer> p = new HashMap<>();
        p.put(null, 22222);
        System.out.println(p.get(null));
        m.put(null, 111);
        Integer integer = m.get(null);
        System.out.println(integer);
    }
}
