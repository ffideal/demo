package com.ffideal.demo08;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/27 14:25
 * @Version: v1.0
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 组定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                // 常驻线程数量（核心）2个
                2,
                // 最大线程数量5个
                5,
                // 线程存活时间:2秒
                2L,
                TimeUnit.SECONDS,
                // 阻塞队列
                new ArrayBlockingQueue<>(3),
                // 默认线程工厂
                Executors.defaultThreadFactory(),
                // 拒绝策略。抛出异常
                new ThreadPoolExecutor.AbortPolicy()
        );

        try{
            for (int i = 1; i <= 8; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭线程池
            threadPool.shutdown();
        }
    }
}
