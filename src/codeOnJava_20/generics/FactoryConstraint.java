/**
 * 有创建工厂的两种不同方法，下面是第一种
 */

package codeOnJava_20.generics;

import onjava.Suppliers;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

// 直接实现了 Supplier
// 有无参构造器
class IntegerFactory implements Supplier<Integer> {
    private int i = 0;
    @Override
    public Integer get() {
        return ++i;
    }
}

// 内部类实现了 Supplier ，传入的时候也传入的是内部类
// 该类没有无参构造器
class Widget {
    private int id;
    Widget(int n) {
        id = n;
    }
    @Override
    public String toString() {
        return "Widget " + id;
    }
    public static class Factory implements Supplier<Widget> {
        private int i = 0;
        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

// 未实现 Supplier
// 有无参构造器
// 可以传入 new Foo2<>() 方法是因为，编译器对函数方法 ::new 的调用，转变成了对 get() 的调用
// 这个有点抽象，编译器做了很多背后工作（Fudge 没有实现 Supplier 接口也没有直接提供 get() 方法）
class Fudge {
    private static int count = 1;
    private int n = count++;
    @Override
    public String toString() {
        return "Fudge " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();
    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }
    @Override
    public String toString() {
        return x.toString();
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2<>(new IntegerFactory()));
        System.out.println(new Foo2<>(new Widget.Factory()));
        System.out.println(new Foo2<>(Fudge::new));
    }
}