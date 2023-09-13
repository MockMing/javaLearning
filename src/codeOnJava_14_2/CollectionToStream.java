/**
 * .stream()
 * Collection 可以使用 stream() 方法生成流
 */

package codeOnJava_14_2;

import java.util.*;

public class CollectionToStream {
    public static void main(String[] args) {
        List<Bubble> bubbles = Arrays.asList(
                new Bubble(1), new Bubble(2), new Bubble(3)
        );
        System.out.println(
                bubbles.stream()
                        // 映射成 Int ，对于 double 和 long 也有 mapToDouble 和 mapToLong
                        .mapToInt(b -> b.i)
                        .sum()
        );

        Set<String> w = new HashSet<>(
                Arrays.asList("It's a wonderful day for pie!".split(" ")
        ));
        w.stream()
                .map(x -> x + " ")
                .forEach(System.out::print);
        System.out.println();

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        // entrySet() 会将 Map 转换为对象，对象的个数是键值对的个数，每个对象拥有一个键和一个值
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }
}
