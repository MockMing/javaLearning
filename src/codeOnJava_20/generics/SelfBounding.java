/**
 * 自限定执行了额外的一步，强制将泛型作为自己的边界参数使用
 */

package codeOnJava_20.generics;

// 标准自限定类型
class SelfBounded<T extends SelfBounded<T>> {       // 要与 BasicHolder 对比
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

class B extends SelfBounded<A> { }          // 这样也可以，前提是上一行的存在，因为此时 A 类型已经确定了，但是 B 不是自限定类型

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
