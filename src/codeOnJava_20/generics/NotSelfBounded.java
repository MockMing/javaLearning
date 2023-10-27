/**
 * 你可以移除该限制，所有的类依然可以编译，但是 E 也可以编译了
 */

package codeOnJava_20.generics;

public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {
        return element;
    }
}

class A2 extends NotSelfBounded<A2> { }

class B2 extends NotSelfBounded<A2> { }

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}

class D2 { }
// 现在可以这样了
class E2 extends NotSelfBounded<D2> { }
