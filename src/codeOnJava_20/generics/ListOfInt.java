/**
 * 自动装箱机制，自动处理 基本类型 和 包装器 类型之间的转换
 */

package codeOnJava_20.generics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = IntStream.range(38, 48)
                .boxed()        // 将 int 元素转换为 Integer 类型
                .toList();
        System.out.println(li);
    }
}
