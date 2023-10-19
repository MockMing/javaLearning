/**
 * 不要轻易否认 <T extends HasF>
 */

package codeOnJava_20.generics;

public class ReturnGenericType<T extends HasF> {
    private T obj;
    ReturnGenericType(T x) {
        obj = x;
    }
    public T get() {
        return obj;
    }
}
