/**
 * 如果没有使用自限定，普通的继承机制就会介入，并且进行重载，就和非泛型情况一样
 */

package codeOnJava_20.generics;

class GenericSetter<T> {
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base);      // 重载，不是覆盖！
    }
}
