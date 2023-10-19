/**
 * 现在你可能认为，对 flist 调用任何有参数的方法都会失败
 */

package codeOnJava_20.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);     // 未产生警告
        flist.contains(new Apple());        // 参数是 Object
        flist.indexOf(new Apple());         // 参数是 Object
    }
}
