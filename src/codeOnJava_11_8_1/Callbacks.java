/**
 * 用内部类实现回调
 */

package codeOnJava_11_8_1;

interface Incrementable {
    void increment();
}

// 非内部类实现接口
class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    // 本类的 increment() 方法和 Incrementable 接口中的 increment() 方法有一致的签名
    public void increment() {
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// 如果我们的类必须以其他某种方式实现 increment() ，则必须使用内部类
class Callee2 extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment();      // 重写基类方法时，可以使用 super 关键字调用基类的该方法，重写接口的方法就不能用 super 了
        i++;
        System.out.println(i);
    }
    // 内部类实现接口
    private class Closure implements Incrementable {
        @Override
        public void increment() {
            // 需要指定 Callee2的 increment() 方法，否则会无限递归
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }
    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);              // [1]
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();                   // [2]
        caller1.go();                   // [2]
        caller2.go();                   // [3]
        caller2.go();                   // [3]
    }
}
