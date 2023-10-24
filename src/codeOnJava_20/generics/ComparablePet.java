/**
 * 基类会劫持接口
 */

package codeOnJava_20.generics;

public class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}
