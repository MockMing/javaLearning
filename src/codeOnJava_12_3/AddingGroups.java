/**
 * 向 Collection 中添加一组元素
 */

package codeOnJava_12_3;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        // [1]
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // [2]
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
                // 此处 addAll() 方法要求的入参为： Collection <? extends java.lang.Integer>
        collection.addAll(Arrays.asList(moreInts));

        // [3] 运行快很多，但是我们无法以这种方式构建 Collection
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // 生成一个底层为数组的列表
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        // list.add(21)     // 底层是数组无法改变大小

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list1.add(6);
        System.out.println(list1);
    }
}
