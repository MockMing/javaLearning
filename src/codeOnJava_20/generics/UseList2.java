/**
 * 在被擦除的参数无法生成独有的参数列表的情况下，你需要提供不相同的方法名
 */

package codeOnJava_20.generics;

import java.util.List;

public class UseList2<W, T> {
    void f1(List<T> v) { }
    void f2(List<W> v) { }
}
