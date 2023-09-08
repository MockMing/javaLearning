package codeOnJava_11_6;

import codeOnJava_11_4.Contents;

/**
 * 匿名内部类
 */

public class Parcel7 {
    // Contents 函数式接口 要求实现方法 int value()
    public Contents contents() {
        // 返回一个匿名内部类
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };      // 这是 return 语句的结尾所以需要分号
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());      // 11
    }
}
