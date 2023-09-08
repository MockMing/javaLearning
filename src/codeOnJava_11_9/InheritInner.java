/**
 * 继承一个内部类
 */

package codeOnJava_11_9;

class WithInner {
    class Inner { }
}

public class InheritInner extends WithInner.Inner {
    //- InheritInner() {}       // 无法编译
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
