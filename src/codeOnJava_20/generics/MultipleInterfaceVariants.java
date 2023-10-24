/**
 * 一个类无法实现同一个接口的两种变体。由于类型擦除，这两个变体实际上是相同的接口
 */

package codeOnJava_20.generics;

interface Payable<T> { }

class Employee implements Payable<Employee> { }

// error
//- class Hourly extends Employee implements Payable<Hourly> { }
