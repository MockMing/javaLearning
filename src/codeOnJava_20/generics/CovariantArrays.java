/**
 * 下例中展示了数组的一种特殊行为——可以将子类的数组赋值给基类数组的引用
 */

package codeOnJava_20.generics;

class Fruit { }
class Apple extends Fruit { }
class Jonathan extends Apple { }
class Orange extends Fruit { }

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();         // OK
        fruit[1] = new Jonathan();      // OK
        // 运行时类型是 Apple[] ，而不是 Fruit[] 或 Orange[]

        try {
            // 编译器允许添加 Fruit
            fruit[0] = new Fruit();     // 会导致 ArrayStoreException 异常
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // 编译器允许添加 Orange
            fruit[0] = new Orange();    // 会导致 ArrayStoreException 异常
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
