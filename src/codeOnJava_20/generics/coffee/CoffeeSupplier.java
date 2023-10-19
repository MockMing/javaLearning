/**
 * 生成随机不同的 Coffee 对象类型的 Supplier<Coffee>
 * 参数化的 Supplier 接口会确保 get() 方法返回的是参数类型
 */

package codeOnJava_20.generics.coffee;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {

    private Class<?>[] types = {
            Latte.class,
            Mocha.class,
            Cappuccino.class,
            Americano.class,
            Breve.class
    };

    private static Random rand = new Random(47);

    public CoffeeSupplier() { }

    private int size= 0;

    public CoffeeSupplier(int sz) {
        size = sz;
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // 内部类 Coffee 迭代器
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }
        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }
        @Override
        public void remove() {      // 未实现
            throw new UnsupportedOperationException();
        }
    }

    // 实现 Iterable 接口。实现了该接口，这个类型就可以用于 for-in 语句
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier())
                .limit(5)
                .forEach(System.out::println);
        for(Coffee c : new CoffeeSupplier(5))
            System.out.println(c);
    }


}
