/**
 * 回顾 协变性 和 通配符
 */

package codeOnJava_20.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    // 兼容每种调用的静态方法，只进行读取操作时，不需要协变性
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    // 类被实例化后，其类型即被确定
    static class Reader<T> {
        T readExact(List<T> list) {         // 与②对比
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();     // ①
        Fruit f = fruitReader.readExact(fruit);
        // errorL incompatible types: List<Apple>
        // 无法转型为 List<Fruit>
        /*
            这里传入 apples ，是传入了 List<Apples> 类型。但是当 Reader<T> 类型实例化为 Reader<Fruit> 类型后（①），
            其方法 readExact(List<T> list) 的参数就被确定为 readExact(List<Fruit> list)，
            那么对这个方法传入 List<Apple> 的行为，就相当于要把 List<Apple> 转型为 List<Fruit> ，自然是不被允许的
         */
        //- Fruit a = fruitReader.readExact(apples);

    }

    static class CovariantRead<T> {
        // 这里的 ? 是实际调用时传入的参数的类型参数。如传入了 apples ，那么 ? 就是 List<Apple> 的 Apple 类型
        T readCovariant(List<? extends T> list) {       // 与②对比
            return list.get(0);
        }
    }

    static void f3() {
        CovariantRead<Fruit> fruitReader = new CovariantRead<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
