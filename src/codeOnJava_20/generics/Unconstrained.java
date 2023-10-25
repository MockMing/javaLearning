/**
 * BasicHolder 可以将任何类型作为其泛型参数
 */

package codeOnJava_20.generics;

class Other { }

class BasicOther extends BasicHolder<Other> { }

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
