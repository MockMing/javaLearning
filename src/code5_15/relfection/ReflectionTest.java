/**
 * 打印一个类的全部信息
 */
package code5_15.relfection;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionTest {
    public static void main(String... args) throws ReflectiveOperationException {
        // 从命令行或用户输入读取类名称
        String name;
        if (args.length > 0)
            name = args[0];
        else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        // 打印类的 修饰符、名字、超类名字(Object 除外)
        Class cl = Class.forName(name);
        // 返回一个字符串，包含 modifiers 中设置的二进制位所对应的修饰符
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0)     // 得到例如 public
            System.out.print(modifiers + " ");
        if (cl.isEnum())
            System.out.print("enum " + name);
        else if (cl.isSealed())     // 只会是 枚举类型 记录类型 接口 其中之一
            System.out.print("record " + name);
        else if (cl.isInterface())
            System.out.print("interface " + name);
        else    // 是一个类
            System.out.print("class " + name);
        Class supercl = cl.getSuperclass();
        if (supercl != null && supercl != Object.class)
            System.out.print(" extends " + supercl.getName());

        // 打印接口
        printInterfaces(cl);

        // 打印允许的子类(前提是密封类)
        printPermittedSubclasses(cl);

        System.out.println("\n{\n");

        System.out.println("    *打印构造器");
        printConstructors(cl);
        System.out.println();

        System.out.println("    *打印方法");
        printMethods(cl);
        System.out.println();

        System.out.println("    *打印字段");
        printFields(cl);
        System.out.println("}");
    }

    /**
     * 打印类的所有构造器
     * @param cl 一个类
     */
    public static void printConstructors(Class cl) {
        // getDeclaredConstructors() 获取全部构造器，不包含超类
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("    ");
            // 得到构造器的修饰符
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // 打印参数类型，返回值是数组
            Class[] paramTypes = c.getParameterTypes();

            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的所有方法
     * @param cl 一个类
     */
    public static void printMethods(Class cl) {
        // getDeclaredMethods() 获取全部方法，不包含超类
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            // 得到返回类型
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            // 打印 修饰符、返回类型、方法名
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // 打印参数类型，返回值是数组
            Class[] paramTypes = m.getParameterTypes();

            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");

        }
    }

    /**
     * 打印类的所有字段
     * @param cl 一个类
     */
    public static void printFields(Class cl) {
        // getDeclaredFields() 获取全部字段，不包含超类
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }

    }


    /**
     * 打印密封类允许的所有子类
     * @param cl 一个类
     */
    public static void printPermittedSubclasses(Class cl) {
        if (cl.isSealed()) {
            Class<?>[] permittedSubclasses = cl.getPermittedSubclasses();
            for (int i = 0; i < permittedSubclasses.length; i++) {
                if (i == 0)
                    System.out.print(" permits ");
                else
                    System.out.print(", ");
                System.out.print(permittedSubclasses[i].getName());
            }
        }
    }

    /**
     * 打印所有直接实现的类接口
     * @param cl 一个类
     */
    public static void printInterfaces(Class cl) {
        Class<?>[] interfaces = cl.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (i == 0)
                System.out.print(cl.isInterface() ? " extends " : " implements ");
            else
                System.out.print(", ");
            System.out.print(interfaces[i].getName());
        }
    }

}
