/**
 * 泛型令人困惑的一点，它可以表达出无意义的事物
 */

package codeOnJava_20.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // 注意这个类型转换
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
