/**
 * 泛型的使用并非强制性的
 */

package codeOnJava_20.generics;

class GenericBase<T> {
    private T element;
    public void set(T arg) {
        element = arg;
    }
    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> { }

// 未使用泛型，这里其实已经出现警告了
// Raw use of parameterized class 'GenericBase'
class Derived2 extends GenericBase { }

// Cannot resolve symbol 'T'
//- class Derived3 extends GenericBase<T> { }

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        // 通过注解关闭该警告
        // Unchecked call to 'set(T)' as a member of raw type 'codeOnJava_20.generics.GenericBase'
        d2.set(obj);
    }
}
