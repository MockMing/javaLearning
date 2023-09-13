package codeOnJava_10_4.filters;

public class Waveform {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
