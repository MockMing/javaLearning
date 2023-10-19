/**
 * Java 编译器无法得知要调用的方法，是否存在于这个对象中，但类似的行为在 C++ 中是可行的
 */

package codeOnJava_20.generics;

class Manipulator<T> {
    private T obj;
    Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
        // Cannot resolve method 'f' in 'T'
        //- obj.f();
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}