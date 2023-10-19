/**
 * 下面是第二种，使用 模板方法设计模式 ，下例中 create() 就是那个模板方法，在子类中被重写，用来生成该类型的对象
 */

package codeOnJava_20.generics;

abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate() {
        element = create();
    }
    abstract T create();
}

class X { }

class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}
