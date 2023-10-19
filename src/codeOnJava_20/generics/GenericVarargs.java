/**
 * 可变参数和泛型方法
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    // @SafeVarargs 声明我们不会对变量参数列表做任何修改，如果没有该注解，编译器就不知道我们会不会修改，就会产生警告
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for(T item : args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        ls = makeList("A", "B", "C");
        System.out.println(ls);

        ls = makeList("ABCDEFGHIGKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
