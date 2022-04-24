package com.ffideal.juc;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ThreadPoolTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/26 23:05
 * @Version: v1.0
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        // 是个顾客请求
        try{
            for (int i = 1; i <= 10; i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }finally {
            // 关闭线程
            threadPool1.shutdown();
        }
    }
}
