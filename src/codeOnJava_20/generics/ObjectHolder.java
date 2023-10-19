/**
 * 在 Java 5 之前，通过持有 Obejct 对象来实现复用
 * ObjectHolder 可以持有任何东西
 */

package codeOnJava_20.generics;

public class ObjectHolder {
    private Object a;
    public ObjectHolder(Object a) {
        this.a = a;
    }
    public void set(Object a) {
        this.a = a;
    }
    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1);  // 自动装箱
        Integer x = (Integer) h2.get();
    }
}
