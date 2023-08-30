package test1;

// 静态引入
import static java.lang.Math.*;


public class test1 {
    public static void main(String[] args) {
//        // 需要声明为枚举类型
//        Size size1 = Size.LARGE;
//        // 取得的 SimpleName 为 Size 也就是原本的枚举类型(并非是可能的String，枚举类型就是枚举类型)
//        System.out.println(size1.getClass().getSimpleName());

        System.out.println("—————————————————1—————————————————");

        int int1 = 10;
        int int2 = 3;
        // 当参与运算的两个数都是整数时，"/"代表整数除法
        System.out.println(int1 / int2);

        double dou1 = 3;
        // 否则代表浮点除法
        System.out.println(int1 / dou1);

        System.out.println("—————————————————2—————————————————");

        // 被除数
        int num1 = -11;
        // 除数
        int num2 = 4;
        // 直接取余运算会得到负数余数，这是错误的
        System.out.println(num1 % num2);

        // 下述方法效果等价，是为了保证余数总要 >= 0
        System.out.println(((num1 % num2) + num2) % num2);
        System.out.println(floorMod(num1, num2));   // (对负除数无效)

        System.out.println("—————————————————3—————————————————");

        double dou2 = 3.5;
        int int3 = (int) dou2;
        System.out.println(int3);
        // round() 四舍五入
        int int4 = (int) round(dou2);   // 需要"(int)"是因为round()默认将数值转变为Long
        System.out.println(int4);

        System.out.println("—————————————————4—————————————————");

        String str1 = String.join("@@@ ", "A", "BC", "DEF");
        System.out.println(str1);

        System.out.println("—————————————————5—————————————————");

        String greeting = "Hello";
        int i = 2;
        // 得到第 i 个码点
        int index = greeting.offsetByCodePoints(0, i);
        int cp = greeting.codePointAt(index);
        System.out.println(cp); // 这里实际上查到的是 'l'，这也是在 ASCII 中对应的

        System.out.println("—————————————————6—————————————————");

        String str2 = """
                Hello
                    nihao
                hi
                """;

        String str3 = """
                    Hello
                        nihao
                    hi
                """;

        System.out.println(str2);
        System.out.println();
        System.out.println(str3);


    }
}
