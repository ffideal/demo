package com.ffideal.demo01;

/**
 * @ClassName: SaleTicketTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/22 10:42
 * @Version: v1.0
 */

class Ticket{
    private int rest = 1000;

    public synchronized void sale() {
        if (rest > 0)
        System.out.println(Thread.currentThread().getName()+"卖出一张票，还剩："+ --rest + "张；");
    }
}



public class SaleTicketTest {
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
