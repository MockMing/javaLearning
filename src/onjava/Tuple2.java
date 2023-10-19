/**
 * 元组
 * 将一组对象包装进一个对象
 * 一般无长度限制，其中每个对象可以是不同的类型，但我们会为其指定类型
 * 取出时是正确的类型，元组会隐式地按顺序存放各个元素
 */

package onjava;

public class Tuple2<A, B> {
    public final A a;
    public final B b;
    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }
    public String rep() {
        return a + ", " + b;
    }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}
