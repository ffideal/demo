package com.ffideal.juc;

/**
 * @ClassName: WhatReentrantSynchronized
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/24 20:34
 * @Version: v1.0
 */

/**
 * 演示可重入锁是什么意思，可重入，就是可以重复获取相同的锁而不会出现死锁
 * synchronized和ReentrantLock都是可重入的
 * */
public class WhatReentrantSynchronized {
    // 创建一个锁对象
    static Object mylock = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            // 创建第一个锁
            synchronized (mylock){
                System.out.println("这是第一层锁");
                synchronized (mylock){
                    System.out.println("这是第二层锁");
                }
            }
        }).start();
    }
}
