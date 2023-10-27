/**
 * Java 5 已经提供了协变返回类型
 */

package codeOnJava_20.generics;

class Base { }
class Derived extends Base { }

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // 覆盖方法的返回类型可以变化
    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
