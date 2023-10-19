/**
 * 使用类型标签
 */

package codeOnJava_20.generics;

class Building { }
class House extends Building { }

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {

        // *isInstance() 后者是否为该类型或其子类型

        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        System.out.println(ctt1.kind.getSimpleName());
        System.out.println(ctt2.kind.getSimpleName());
    }
}
