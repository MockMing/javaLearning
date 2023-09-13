package codeOnJava_10_4.interfaceprocessor;

import java.util.Arrays;

public interface StringProcessor extends Processor {
    @Override
    String process(Object input);           // 这个声明不是必要的，删除不会报错，但是它可以指出方法的返回值从 Object 协变为 String
    String S = """                          
            If she weighs ths same as a duck, she's made of wood
            """;                            // 该字段定义在接口内，自动为 static 和 final
    static void main(String[] args) {       // 可以在接口内定义一个用于测试的 main() 方法
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }
}

class Upcase implements StringProcessor {
    @Override   // 协变返回
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override   // 协变返回
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override   // 协变返回
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}