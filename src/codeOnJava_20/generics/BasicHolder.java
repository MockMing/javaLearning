/**
 * Java 的重点在于参数和返回类型，因此可以生成将派生类型作为参数和返回值的基类。也可以将派生类型作为字段的类型，尽管它们会被擦除为 Object
 */

package codeOnJava_20.generics;

public class BasicHolder<T> {
    T element;
    void set(T arg) {
        element = arg;
    }
    T get() {
        return element;
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
