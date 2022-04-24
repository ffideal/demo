package com.ffideal.juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SynchronizedLockTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/24 11:56
 * @Version: v1.0
 */

class Phone {

    public synchronized void sendSMS() throws Exception {
        //停留4秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------sendSMS");
    }
    public synchronized void sendEmail() throws Exception {
        System.out.println("------sendEmail");
    }
    public void getHello() {
        System.out.println("------getHello");
    }
}

public class SynchronizedLockTest {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                // phone.sendEmail();
                // phone.getHello();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}