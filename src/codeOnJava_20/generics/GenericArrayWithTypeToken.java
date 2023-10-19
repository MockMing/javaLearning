/**
 * 对于新代码，应该传入一个类型标记
 */

package codeOnJava_20.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return (T) array[index];
    }

    // 暴露潜在的表达方式
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        // 现在可以正常运行了
        Integer[] ia = gai.rep();
    }
}
