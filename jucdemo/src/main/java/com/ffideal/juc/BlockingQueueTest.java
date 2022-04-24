package com.ffideal.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @ClassName: BlockingQueueTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/26 14:03
 * @Version: v1.0
 */

public class BlockingQueueTest {
    public static void main(String[] args) {
        // 创建阻塞队列
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        // 当队列中加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 检查
        System.out.println(blockingQueue.element());
        /** 此时输出的结果为
         * true
         * true
         * true
         * a
         * */
        // 此时再添加元素，会抛出异常:IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));
        // 取出元素
        System.out.println(blockingQueue.poll());
        // 检查
        System.out.println(blockingQueue.element());
        /** 此时输出的结果为
         * true
         * true
         * true
         * a
         * a (取出数据)
         * b (队首数据)
         * */
    }
}
