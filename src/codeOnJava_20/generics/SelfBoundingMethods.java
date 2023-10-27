/**
 * 可以将自限定用于泛型方法
 */

package codeOnJava_20.generics;

public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
