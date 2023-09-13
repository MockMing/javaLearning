package codeOnJava_10_4.interfaceprocessor;

public class Applicator {
    // 主要是为了让 Processor p 这个参数更容易复用
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
