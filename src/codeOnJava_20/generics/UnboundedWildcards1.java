/**
 * 无界通配符
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;

        // warning
        list3 = list;
        // 未经检查的类型转换：
        // list3 = list;
        //          ^
        // required:    List<? extends Object>
        // found:       List
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;

        // 这里就没有警告
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());

        // 2 warnings
        assign3(new ArrayList());
        // warning1
        // 未经检查的方法调用：
        // assign3(new ArrayList())
        //    ^
        // required:    List<? extends Object>
        // found:       ArrayList
        //
        // warning2
        // 未经检查的类型转换：
        // assign3(new ArrayList())
        //                 ^
        // required:    List<? extends Object>
        // found:       ArrayList

        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        // 以下两种形式都可以作为 List<?> 被接受
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();
        // 无警告
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
