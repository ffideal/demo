package com.ffideal.demo02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LSaleTicketTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/22 17:32
 * @Version: v1.0
 */
class Ticket{
    private int rest = 30;

    // 创建可重入锁，在构造器中为true则为公平锁，默认为false
    private final ReentrantLock lock = new ReentrantLock(true);

    public synchronized void sale() {
        //由于要防止上锁后出现异常导致无法解锁，所以使用try-catch-finally结构来解决
        try {
            //上锁
            lock.lock();

            if (rest > 0)
                System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩：" + --rest + "张；");
        }finally {
            //解锁
            lock.unlock();
        }
    }
}

public class LSaleTicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    ticket.sale();
                }
            }
        };
        new Thread(r, "A").start();
        new Thread(r, "B").start();
        new Thread(r, "C").start();

    }
}
