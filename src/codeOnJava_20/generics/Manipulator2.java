/**
 * 为泛型类规定边界
 */

package codeOnJava_20.generics;

class Manipulator2<T extends HasF> {
    private T obj;
    Manipulator2(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
