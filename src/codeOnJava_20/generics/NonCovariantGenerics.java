/**
 * 虽然我们能够在运行时发现插入了一个不恰当的类型，但是泛型的主要目的之一就是让这样的错误检查提前到编译时。我们尝试用泛型集合替代数组
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
    // 这会报错 Complie Error: incompatible types:
    //- List<Fruit> flist = new ArrayList<Apple>();
}
