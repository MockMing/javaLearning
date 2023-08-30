package code5_16.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 本程序使用反射监视对象
 * 在 java17 会抛出异常 InaccessibleObjectException 需要 P211 指定的操作
 * 在 java9~16 会有警告
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 将对象转换为列出所有字段的字符串表示形式
     * @param obj 一个对象
     * @return 一个带有对象的类名和所有字段名和字段值的字符串
     */
    public String toString(Object obj) throws ReflectiveOperationException {

        if (obj == null)
            return null;

        if (visited.contains(obj))
            return "...";

        // 访问过的对象放入 visited
        visited.add(obj);
        Class<?> cl = obj.getClass();

        if (cl == String.class)
            return (String) obj;

        // 如果 obj 是数组
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    r += ",";
                Object val = Array.get(obj, i);
                // 如果数组中的是 基本类型
                if (cl.getComponentType().isPrimitive())
                    r += val;
                // 如果数组中的是 非基本类型
                else
                    r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // 检查这个类和所有超类的字段
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // 取得所有字段的名字和值
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("["))
                        r += ",";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    if (t.isPrimitive())
                        r += val;
                    else
                        r += toString(val);
                }
                r += "]";
                cl = cl.getSuperclass();
            }
        } while (cl != null);

        return r;
    }
}
