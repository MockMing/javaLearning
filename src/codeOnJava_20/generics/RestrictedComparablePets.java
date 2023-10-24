/**
 * 实现完全相同的接口（包括参数类型）不会被基类拦截 或 不声明实现接口，直接覆盖同名方法也不会被拦截
 */

package codeOnJava_20.generics;

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}