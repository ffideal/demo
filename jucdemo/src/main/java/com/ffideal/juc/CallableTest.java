package com.ffideal.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallableTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/24 21:22
 * @Version: v1.0
 */

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行Runnable");
        }).start();
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "使用Callable接口");
            return "Callable接口返回值";
        });
        new Thread(task).start();
        System.out.println("Callable返回值：" + task.get());
    }
}
