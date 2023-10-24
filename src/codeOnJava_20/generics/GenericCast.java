/**
 * 集合在内部将元素存储为 Object 并在读取的时候转回 T
 */

package codeOnJava_20.generics;

import java.util.Arrays;
import java.util.stream.Stream;

class FixedSizeStack<T> {
    private final int size;
    private Object[] storage;
    private int index = 0;
    FixedSizeStack(int size) {
        this.size = size;
        storage = new Object[size];
    }

    public void push(T item) {
        if(index < size)
            storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return index == 0 ? null : (T) storage[--index];
    }

    @SuppressWarnings("unchecked")
    Stream<T> stream() {
        return (Stream<T>) Arrays.stream(storage);
    }
}

public class GenericCast {
    static String[] letters = "ABCDEFGHIJKLMNOPQRS".split("");

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(letters.length);
        Arrays.stream("ABCDEFGHIJKLMNOPQRS".split("")).forEach(strings::push);
        System.out.println(strings.pop());
        strings.stream()
                .map(s -> s + " ")
                .forEach(System.out::print);
    }
}
