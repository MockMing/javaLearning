/**
 * 可用于所有类型的 list ，调用 select() 从其中随机获取一个元素
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);
    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream(          // 由于是泛型的，可以适配任何类型
                ("The quick brown fox jumped over the lazy brown dog").split(" ")
        ).forEach(rs::add);
        IntStream.range(0, 11).forEach(
                i -> System.out.print(rs.select() + " ")
        );
    }
}
