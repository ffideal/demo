package com.ffideal.demo03;

/**
 * @ClassName: InterThreadCommunication
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/22 20:09
 * @Version: v1.0
 */

// 创建一个资源类
class Share{
    // 设置临界资源
    private int number = 0;

    // 实现+1操作
    public synchronized void incr() throws InterruptedException {
        // 操作：判断、干活、通知
        while (number != 0) {
            // number不为0，等待
            // 哪里睡哪里起
            this.wait();
        }
        number++;
        System.out.print(Thread.currentThread().getName()+"::"+number+"--->");
        // 唤醒其他线程
        this.notifyAll();
    }

    // 实现-1操作
    public synchronized void decr() throws InterruptedException {
        // 操作：判断、干活、通知
        while (number != 1) {
            // number不为0，等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        this.notifyAll();
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        share.incr();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    for (int i = 0; i < 100; i++) {
                        share.incr();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
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
