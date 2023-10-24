/**
 * 下面的代码无法编译，即使看上去很合理
 */

package codeOnJava_20.generics;

import java.util.List;

public class UseList<W, T> {
    //- void f(List<T> v) { }
    //- void f(List<W> v) { }
}
