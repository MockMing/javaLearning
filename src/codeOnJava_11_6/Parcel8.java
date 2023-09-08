package codeOnJava_11_6;

import test1.Wrapping;

public class Parcel8 {
    public Wrapping wrapping(int x) {
        // 基类构造器调用
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());      // 470
    }
}
