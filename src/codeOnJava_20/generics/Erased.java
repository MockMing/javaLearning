/**
 * 由于类型擦除，任何需要在运行时知道确切类型的操作都无法运行
 */

package codeOnJava_20.generics;

public class Erased<T> {
    private final int SIZE = 100;
    public void f(Object arg) {

        // 非法泛型类型。由于不知道 T 到底是什么类型，无法进行判断
        // -if(arg instanceof T) ;

        // 无法预期的类型，也就没法实例化
        //- T var = new T();

        // 同上
        //- T[] array = new T[SIZE];

        // 未经检查的转型
        //- T[] array = (T[]) new Object()[SIZE];
    }
}
