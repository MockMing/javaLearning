/**
 * 泛型的主要目的之一是限制集合能持有的对象类型，并通过编译器强制执行该规范
 * 显然持有 Object 不能限制集合持有的对象类型
 * 指定类型占位符取代 Object ，在使用时再确定具体的类型
 */

package codeOnJava_20.generics;

public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public void set(T a) {
        this.a = a;
    }
    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile());   // 类型已检查
        Automobile a = h3.get();    // 不需要转型
        // 无法将 h3 设置为 Automobile 之外的类型，只能将 Automobile 及其子类型放入这个 holder
    }
}
