/**
 * 在本例中，无需依赖泛型
 */

package codeOnJava_20.generics;

class Manipulator3 {
    private HasF obj;
    Manipulator3(HasF x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
