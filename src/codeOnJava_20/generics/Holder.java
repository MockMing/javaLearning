/**
 * 泛型类设计者们可以决定哪种调用是 “安全的” ，从而将 Object 类型作为它们的参数。要拒绝使用通配符类型的调用，需要在参数列表中使用类型参数
 */

package codeOnJava_20.generics;

import java.util.Objects;

public class Holder<T> {
    private T value;

    public Holder() { }
    public Holder(T val) {
        value = val;
    }

    // 参数为类型参数，因为涉及到修改对象
    public void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }

    // “安全的” 方法，equals() 不会修改对象
    @Override
    public boolean equals(Object o) {
        return o instanceof Holder && Objects.equals(value, ((Holder) o).value);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        // 未涉及通配符
        Holder<Apple> apple = new Holder<>(new Apple());

        Apple d = apple.get();
        apple.set(d);

        // 无法向上转型，泛型不具备协变性
        //- Holder<Fruit> Fruit = apple;

        // OK 涉及到通配符，赋予泛型协变性
        Holder<? extends Fruit> fruit = apple;

        Fruit p = fruit.get();

        Apple d2 = (Apple) fruit.get();

        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }

        // 无法调用 set() ，因为参数列表使用了类型参数
        //- fruit.set(new Apple());
        //- fruit.set(new Fruit());

        // OK
        System.out.println(fruit.equals(d));
    }
}
