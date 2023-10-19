/**
 * 生成斐波那契数列
 * Supplier<?> 这个接口会确保 get() 方法返回的是参数类型
 * 比如此处的 Supplier<Integer> 可以换为 Supplier<Number> 因为 这个 Supplier 提供了 Integer 可以视为提供了 Number
 */

package codeOnJava_20.generics;

import java.util.function.*;
import java.util.stream.Stream;

public class Fibonacci implements Supplier<Integer> {
    private int count = 0;
    @Override
    public Integer get() {
        return fib(count++);
    }
    private int fib(int n) {

        if(n < 2)
            return 1;

        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
