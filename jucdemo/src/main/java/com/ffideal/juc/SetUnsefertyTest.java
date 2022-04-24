package com.ffideal.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName: SetUnsefertyTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/23 22:08
 * @Version: v1.0
 */

public class SetUnsefertyTest {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>();
        // Vector<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
