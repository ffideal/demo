package com.ffideal.juc;

/**
 * @ClassName: CreateThreadTest01
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/22 18:19
 * @Version: v1.0
 */

public class CreateThreadTest01 extends Thread{
    private int rest = 1000;

    // 重写run()方法，方法体就是线程执行体
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (rest > 0)
                System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩：" + --rest + "张；");
        }
    }

    public static void main(String[] args) {
        //创建两条线程
        new CreateThreadTest01().start();
        new CreateThreadTest01().start();

    }
}
