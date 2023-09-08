package codeOnJava_10_4.interfaceprocessor;

import codeOnJava_10_4.filters.*;

class FilterAdapter implements Processor {
    Filter filter;
    FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }
    @Override   // 实现 Processor 接口 的 process(Object input) 要求传入 Object 类型，但是回参为 Waveform 是协变返回，调用 filter.process() 相当于委托
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(
                // FilterAdapter() 实例化可以得到一个实现了 Processor 接口的对象
                // Applicator.apply() 第一个参数是 Processor
                // *主要是需要一个特定的实现了 Processor 接口的对象
                new FilterAdapter(new LowPass(1.0)),
                w);
        Applicator.apply(
                new FilterAdapter(new HighPass(2.0)),
                w);
        Applicator.apply(
                new FilterAdapter(new BandPass(3.0, 4.0)),
                w);
    }
}
