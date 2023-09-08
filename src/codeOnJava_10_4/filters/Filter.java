package codeOnJava_10_4.filters;
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }
    // 此处如果协变返回类型，则返回的类型是 Waveform 的子类
    // 传入的对象也需要是 Waveform 的子类
    // 哑处理。基类的该方法无任何处理直接返回
    public Waveform process(Waveform input) {
        return input;
    }
}
