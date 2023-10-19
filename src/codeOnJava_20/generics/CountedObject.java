/**
 * 简单的具有无参构造的类
 * 没有创建任何构造器，所有有一个编译器提供的无参构造器
 */

package codeOnJava_20.generics;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    private long id() {
        return id;
    }
    @Override
    public String toString() {
        return "CountedObject" + id;
    }
}
