/**
 * 通过继承生成适配器类，来给 斐波那契数列 实现 Iterable 接口
 * 支持 Iterable 接口的 斐波那契数列
 * 使用 适配器设计模式
 */

package codeOnJava_20.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.get();
            }

            @Override
            public void remove() {      // 未实现
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        // 传入18意思是调用迭代器18次，也就会生成18个数字
        for(int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
