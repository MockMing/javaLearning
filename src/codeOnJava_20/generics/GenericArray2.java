/**
 * 更好的办法是，在集合内使用 Object[] ，在使用某个数组元素时，再增加转型为 T 的操作（把 Object转换为 T ，而不是把 Object[] 转换为 T[] ）
 */

package codeOnJava_20.generics;

public class GenericArray2<T> {
    // 使用 Object[]
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    // 取出时转型为 T
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    // 未检查的类型转换，错误示范
    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for(int i = 0; i < 10; i++)
            gai.put(i, i);
        for(int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
