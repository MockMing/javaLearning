/**
 * 被基类劫持接口的子类
 */

package codeOnJava_20.generics;

// error
/*
class Cat extends ComparablePet implements Comparable<Cat> {
    public int compareTo(Cat arg) {
        return 0;
    }
}
*/