package com.ffideal.demo04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: InterThreadCommunication
 * @Description: 使用Lock实现线程间通信
 * @Author: ffideal
 * @Date: 2022/1/22 20:09
 * @Version: v1.0
 */

class Share {
    // 设置临界资源
    private int number = 0;
    // 创建一个Com
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 实现+1操作
    public void incr() {
        // 上锁
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await();
            }
            // 干活
            number++;
            System.out.print(Thread.currentThread().getName() + "::" + number + "--->");
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 实现-1操作
    public void decr() throws InterruptedException {
        // 上锁
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class LInterThreadCommunication {
        public static void main(String[] args) {
        Share share = new Share();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    share.incr();
                }

            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        share.decr();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    share.incr();
                }

            }
        },"C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        share.decr();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}