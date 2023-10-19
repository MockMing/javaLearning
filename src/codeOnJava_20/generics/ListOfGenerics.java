/**
 * 用 ArrayList 来创建泛型数组，而不是 T[]
 */

package codeOnJava_20.generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item) {
        array.add(item);
    }
    public T get(int index) {
        return array.get(index);
    }
}
