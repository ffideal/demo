package com.ffideal;

/**
 * @ClassName: ClassInitTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/21 15:08
 * @Version: v1.0
 */

public class ClassInitTest {

    private static int num = 1;

    static {
        num = 2;
        number = 20;
//        System.out.println(number);  报错，非法的前向引用
    }

    private static int number = 10;//linking::prepare::number=0-->initial:20--> 10
    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);  //输出2
        System.out.println(ClassInitTest.number);//输出10
    }
}
