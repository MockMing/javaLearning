package codeOnJava_10_4.interfaceprocessor;

public interface Processor {
    // default 是为了方便复用
    default String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input);
}
