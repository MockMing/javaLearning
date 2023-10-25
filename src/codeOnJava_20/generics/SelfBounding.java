/**
 * 自限定执行了额外的一步，强制将泛型作为自己的边界参数使用
 */

package codeOnJava_20.generics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {
        return element;
    }
}

class A extends SelfBounded<A> { }

class B extends SelfBounded<A> { }

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D { }

// error
//- class E extends SelfBounded<D> { }
// Type  parameter D is not within its bound
// D 无法满足 <T extends SelfBounded<T>>

// 你可以这样做，所以你无法强制使用这种用法
class F extends SelfBounded { }

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
