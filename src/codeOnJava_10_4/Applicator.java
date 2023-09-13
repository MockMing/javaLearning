package codeOnJava_10_4;

import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    // 哑处理。基类的该方法无任何处理直接返回
    public Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override   // 协变返回
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override   // 协变返回
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override   // 协变返回
    public String process(Object input) {
        // split() 把一个字符串拆分为几部分，本例在遇到 " " 时进行拆分
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Applicator {
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made on";
        apply(new Upcase(), s);
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }
}
