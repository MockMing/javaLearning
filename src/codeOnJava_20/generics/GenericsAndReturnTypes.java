/**
 * 自限定类型实际上会生成精确的派生类型作为返回值，如下面的 get()
 */

package codeOnJava_20.generics;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

// 此时，对于这个接口，T 是 Getter
interface Getter extends GenericGetter<Getter> { }

public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result = g.get();
        GenericGetter gg = g.get();     // 也可以是基类，向上转型
    }
}
