/**
 * 通配符 可以建立某种向上转型的关系
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        // 通配符提供了协变性的能力。后面的钻石语法可以放入 Apple 类型
        List<? extends Fruit> flist = new ArrayList<>();

        // Compile Error: can't add any type of object:
        //- flist.add(new Apple());
        //- flist.add(new Fruit());
        //- flist.add(new Object());

        flist.add(null);        // 不会报错，但是没有意义

        // 我们至少可以返回 Fruit
        Fruit f = flist.get(0);
    }
}
