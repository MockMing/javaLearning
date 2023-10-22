/**
 * 由 Byte 组成的 Set
 */

package codeOnJava_20.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ByteSet {
    Byte[] possibles = { 1,2,3,4,5,6,7,8,9 };
    Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));

    // 但你不能这样：
    //- Set<Byte> mySet2 = new HashSet<>(Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));
    // 这里相当于先创建一个 int 基本类型 数组，然后试图转型为 Byte 包装类 类型数组，int[] -> Byte[] 报错了。
    // 前者是先创建 Byte[] ，然后用这个数组创建了 List 。
}
