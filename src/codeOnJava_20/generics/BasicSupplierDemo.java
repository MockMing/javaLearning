/**
 * 使用 BasicSupplier 为 CountedObject 创建 Supplier
 */

package codeOnJava_20.generics;

import java.util.stream.Stream;

public class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(
                BasicSupplier.create(CountedObject.class)
        )
                .limit(5)
                .forEach(System.out::println);
    }
}
