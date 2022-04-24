package com.ffideal;

/**
 * @ClassName: ClinitTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/21 15:19
 * @Version: v1.0
 */

public class ClinitTest {
    // 任何一个类声明以后，内部至少存在一个类的构造器，对应着字节码中<init>
    private int a = 100;

    public ClinitTest(){
        a = 10;
        int d = 20;
    }
    private static int c = 3;
    public static void main(String[] args) {
        int b = 2;
    }
}
