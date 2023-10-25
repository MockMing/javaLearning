/**
 * 泛型参数是无法直接继承的 。不过，可以继承一个在自身定义中用到了该泛型参数的类
 */

package codeOnJava_20.generics;

class GenericType<T> { }

public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> { }
