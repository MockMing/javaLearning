package codeOnJava_10_4.filters;

public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }
    // 也是哑处理
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
