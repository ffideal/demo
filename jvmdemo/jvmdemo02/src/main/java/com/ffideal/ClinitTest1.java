package com.ffideal;

/**
 * @ClassName: ClinitTest1
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/21 15:58
 * @Version: v1.0
 */

public class ClinitTest1 {
    static class Father{
        public static int a = 10;
        static {
            a = 200;
        }
    }

    static class Son extends Father{
        public static int b = a;
    }

    public static void main(String[] args) {
        // 先加载Father类，载加载Son类
        System.out.println(Son.b);
    }
}
