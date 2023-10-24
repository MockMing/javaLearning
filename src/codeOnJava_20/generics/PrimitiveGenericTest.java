/**
 * 描述待补充
 */

package codeOnJava_20.generics;

import onjava.Rand;

import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

// 用生成器填充数组
interface FillArray {
    // 通用的
    static <T> T[] fill(T[] a, Supplier<T> gen) {
        Arrays.setAll(a, n -> gen.get());
        return a;
    }

    // 处理基本类型的
    static int[] fill(int[] a, IntSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsInt());
        return a;
    }
    static long[] fill(long[] a, LongSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsLong());
        return a;
    }
    static double[] fill(double[] a, DoubleSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsDouble());
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FillArray.fill(new String[5], new Rand.String(9));
        System.out.println(Arrays.toString(strings));

        int[] integers = FillArray.fill(new int[9], new Rand.Pint());
        System.out.println(Arrays.toString(integers));
    }
}
