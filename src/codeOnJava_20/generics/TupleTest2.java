/**
 * 修改 TupleTest 测试 Tuple.java
 */

package codeOnJava_20.generics;

import onjava.*;

import static onjava.Tuple.tuple;

public class TupleTest2 {
    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    // 返回了未参数化的 Tuple2 对象，返回值未以参数化的方式使用所有编译器没有发出警告
    static Tuple2 f2() {
        return tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());

        // 老方法
        Tuple2<String, Integer> tp1 = new Tuple2<>("abc", 123);
        System.out.println(tp1);

        // 新方法
        Tuple2<String, Integer> tp2 = tuple("def", 456);
        System.out.println(tp2);
    }
}
