package com.ffideal.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: WhatReentrantLock
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/24 20:41
 * @Version: v1.0
 */

/**
 * lock和unlock的数量必须一致，否则会出现死锁
 * */
public class WhatReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            // 上锁
            lock.lock();
            try {
                System.out.println("这是第一层锁");
                // 再次上锁
                lock.lock();
                try{
                    System.out.println("这是第二层锁");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
