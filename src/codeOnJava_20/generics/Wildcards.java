/**
 * 什么时候编译器才关心 原生类型 和 带有无界通配符的类型（ <?> 非原生类型） 之间的区别呢？
 * 该示例内部包含若干不同形式的，以 Holder 为参数的方法——以原始类型方式、带有具体的类型参数，以及带有无界通配符的参数
 */

package codeOnJava_20.generics;

public class Wildcards {
    // 原始类型
    static void rawArgs(Holder holder, Object arg) {
        // warning
        holder.set(arg);
        // *编译器知道 Holder 是泛型类型，即使它在 rawArgs(Holder holder, Object arg) 这里被表示为原始类型，编译器也知道向其中传入 Object 是不安全的。
        // 因为它是原始类型，所以可以向 set() 中传入任何类型的对象，该对象会被向上转型为 Object 。
        // 不论何时，使用原始类型就意味着放弃 编译时检查 。

        // 未涉及 T
        //- T t = holder.get();

        // 会丢失类型信息
        Object obj = holder.get();
        // *对 get 的调用也有同样的问题：因为没有 T ，结果只能是 Object 。
    }


    // <?> 。本例和 rawArgs() 类似，但会产生错误而不是警告
    static void unboundedArg(Holder<?> holder, Object arg) {
        // error
        //- holder.set(arg);
        // *在这里可以看出原生 Holder 和 Holder<?> 的区别，相较于上一个的方法，编译器发出了警告，这里直接报错：
        // 因为原生 Holder 可以持有 任何类型的组合 ，而 Holder<?> 只能持有由 某种具体类型组成的单类型集合 。所以你不能只传入一个 Object 。

        // *我个人另一种理解方式：Holder 使用原始类型，可以看作是 Holder<Object> 。而 Holder<?> 代表一定会使用某个具体类型，只是这个类型到底是啥，我们和编译器都不在意。
        // 那么如前一个例子，向 Holder<Object> 中传入任何类型，都将被视为传入 Object ，也是能被接收的。
        // 但是对于本例，向 Holder<?> 中传入一个 Object ，那就把 ? 当做 Object 了，但 ? 的含义不是这个，这么看，报错也是理所应当。

        // 未涉及 T
        //- T t = holder.get();

        // 会丢失类型信息
        Object obj = holder.get();
    }


    // 精确类型
    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    // *使用了精确的泛型参数，没有使用通配符。由于存在额外的参数，exact2() 所受的限制和 exact1() 并不同。
    // exact2() 明确了要求传入 T arg


    // <? extends T>
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // error
        //- holder.set(arg);
        // *和 unboundedArg() 有些相似。这里放宽了 Holder 类型的限制，只要求 Holder 持有的类型满足 extends T 。
        // 这里不允许调用 set() 是在预期内的。我们不能确定 Holder 持有的类型是 T 的哪个子类，自然任何类型都不被允许存入。但是读取是安全的，任何从 Holder 读取的类型都可以看作 T 类型。
        // 还是举个例子，例如 T 是 Fruit ，那么 Holder 可能持有 Fruit、Apple、Orange 等，禁止任何修改操作，可以防止 Orange 存入 Holder<Apple>，

        // <? extends T> 特点是 安全读取，非安全修改 ？

        return holder.get();
    }


    // <? super T>
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);

        // error
        //- T t = holder.get();
        // Holder 的参数类型可能是 T 的任何基类，那么 T 及其子类型都可以安全的存入其中。
        // 比如 T 是 Apple ，那么 ? 可能是 Fruit 或者 Object 什么的，那么 Apple 及其子类的存入就是安全的。
        // 读取操作是允许的，但是因为不知道 ? 到底是 T 的哪个基类，所以只能向上转型为 Object 。

        // <? super T> 特点是 安全修改，读取只能是 Object ？


        Object obj = holder.get();
    }


    public static void main(String[] args) {

        Holder raw = new Holder<>();
        // 或者：
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();

        Long lng = 1L;

        // static void rawArgs(Holder holder, Object arg) { ... }
        // *为了迁移兼容，rawArgs() 可以接收 Holder 的所有不同变种，不产生警告。
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        // static void unboundedArg(Holder<?> holder, Object arg) { ... }
        // *同样可以接收所有的类型，但方法内部对这些参数的处理是不同的。
        // 这里 holder.set() 不能接收 Object
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);


        // static <T> T exact1(Holder<T> holder) { ... }
        // *这里的 exact1() 接收原生 Holder 类型的引用会产生警告，因为具体参数所需的信息在原生类型中不存在
        // 2 warnings
        Object r1 = exact1(raw);

        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);


        // static <T> T exact2(Holder<T> holder, T arg) { ... }
        // * exact2() 限制最大，因为它明确要求传入 Holder<T> 和 参数类型 T 。如果没有传入指定的参数，就会产生错误或警告
        // 2 warnings
        Long r5 = exact2(raw, lng);

        Long r6 = exact2(qualified, lng);

        // error
        //- Long r7 = exact2(unbounded, lng);

        // error
        //- Long r8 = exact2(bounded, lng);


        // static <T> T wildSubtype(Holder<? extends T> holder, T arg) { ... }
        // *与传入精确类型相比，wildSubtype() 和 wildSupertype() 就没有那么严格了。
        // 但仍然取决于你是要 从泛型参数获得类型化的返回值（ wildSubtype() ），
        // 还是要 向泛型参数中传入类型化参数（ wildSupertype() ）。
        // 2 warnings
        Long r9 = wildSubtype(raw, lng);

        Long r10 = wildSubtype(qualified, lng);

        // 这样可以，但只能返回 Object
        Object r11 = wildSubtype(unbounded, lng);

        Long r12 = wildSubtype(bounded, lng);


        // static <T> void wildSupertype(Holder<? super T> holder, T arg) { ... }
        // 2 warnings
        wildSupertype(raw, lng);

        wildSupertype(qualified, lng);

        // error
        //- wildSupertype(unbounded, lng);

        // error
        //- wildSupertype(bounded, lng);

    }
}
