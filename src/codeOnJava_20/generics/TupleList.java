/**
 * 泛型简单且安全地创建复杂模型
 * 存放元组地列表
 */

package codeOnJava_20.generics;

import onjava.Tuple4;
import java.util.ArrayList;

// 定义元组列表，重点在于继承
public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        tl.forEach(System.out::println);
    }
}
