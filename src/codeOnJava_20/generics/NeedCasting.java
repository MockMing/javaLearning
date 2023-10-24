/**
 * 有时使用泛型依然需要转型，而且会导致编译器产生不正确的警告
 */

package codeOnJava_20.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> shapes = (List<Widget>) in.readObject();
    }
}
