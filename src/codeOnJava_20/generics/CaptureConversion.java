/**
 * 有种情况特别需要使用 <?> 而不是原生类型。如果向某个使用了 <?> 的方法传入了原生类型，编译器有可能会推断出具体的类型参数，因此该方法可以转而调用另一个使用了该具体类型的方法
 * 下面这个示例演示了这项技巧，该技巧被称为 捕获转换 ，因为它可以捕获未指定的通配符类型，并将其转化为某个具体类型
 */

package codeOnJava_20.generics;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);     // 用捕获的类型来调用方法
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);

        // 2 warnings
        f1(raw);
        // 输出：Integer

        f2(raw);        // 不产生警告
        // 输出：Integer


        Holder rawBasic = new Holder();

        // 1 warning
        rawBasic.set(new Object());

        f2(rawBasic);   // 不产生警告
        // 输出：Object


        // 向上转型为 Holder<?> ，仍可推断出具体类型
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
        // 输出：Double
    }
}
