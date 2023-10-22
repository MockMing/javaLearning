/**
 * 在处理多重泛型参数时，有时需要将参数初始化为某种具体类型时，允许其中某个参数可以是任何类型
 */

package codeOnJava_20.generics;

import java.util.HashMap;
import java.util.Map;

public class UnboundedWildcards2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String,?> map3;

    static void assign1(Map map) {
        map1 = map;
    }
    static void assign2(Map<?,?> map) {
        map2 = map;
    }
    static void assign3(Map<String,?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());

        // 2 warnings
        assign3(new HashMap());
        // warning 1
        // 未经检查的方法调用
        // assign3(new HashMap());
        //    ^
        // required:    Map<String,?>
        // found:       HashMap
        //
        // warning 2
        // 未经检查的类型转换
        // assign3(new HashMap());
        //               ^
        // required:    Map<String,?>
        // found:       HashMap


        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }
}
