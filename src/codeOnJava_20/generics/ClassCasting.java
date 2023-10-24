/**
 * 使用 Java 5 中引入的转型方式，通过泛型类来转型
 */

package codeOnJava_20.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));

        // 无法编译
        //- List<Widget> lw1 = List<>.class.cast(in.readObject());
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
