/**
 * 在使用自限定类型的时候，子类中只有一个方法，而该方法将派生类型作为自身参数，而不是基类类型
 */

package codeOnJava_20.generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> { }

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);

        // error
        //- s1.set(sbs);
    }
}
