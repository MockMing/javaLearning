/**
 * 通用 Supplier
 * 可以为任何具有无参构造器的类生成一个 Supplier
 */

package codeOnJava_20.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;
    public BasicSupplier(Class<T> type) {
        this.type = type;
    }
    @Override
    public T get() {
        try {
            // 假定类型是 public 的类
            return type.getConstructor().newInstance();
        } catch (InstantiationException |
                NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // 基于类型标记生成默认的 Supplier
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
