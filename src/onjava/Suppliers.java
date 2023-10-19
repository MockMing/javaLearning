/**
 * 使用 Supplier 的泛型方法
 */

package onjava;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Suppliers {
    // 创建并填充一个集合
    public static <T, C extends Collection<T>> C create(
            Supplier<C> factory,
            Supplier<T> gen,
            int n) {

        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }

    // 填充已有集合
    public static <T, C extends Collection<T>> C fill(
            C coll,
            Supplier<T> gen,
            int n) {

        Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);

        return coll;
    }

    // 使用未绑定的方法引用生成更为通用的方法
    public static <H, A> H fill(
            H holder,
            BiConsumer<H, A> adder,
            Supplier<A> gen, int n) {

        Stream.generate(gen)
                .limit(n)
                .forEach(a -> adder.accept(holder, a));

        return holder;
    }
}
