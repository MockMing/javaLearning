/**
 * 如果使用元组，就需要为含税㐉长度合适的元组作为返回值，然后创建该元组并返回
 */

package codeOnJava_20.generics;

import onjava.*;

public class TupleTest {
    static Tuple2<String, Integer> f() {
        // 自动装箱将 int 转换为 Integer
        return new Tuple2<>("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // Cannot assign a value to final variable 'a'
        //- ttsi.a = "anything";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
