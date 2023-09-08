package codeOnJava_10_4.filters;

public class BandPass extends Filter{
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    // 也是哑处理
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
