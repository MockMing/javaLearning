/**
 * 简单泛型
 * 泛用性太低了
 */

package codeOnJava_20.generics;

class Automobile {}

public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }
    Automobile get() {
        return a;
    }
}
