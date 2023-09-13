package codeOnJava_11_6;

import codeOnJava_11_4.Destination;

/**
 * 匿名内部类中使用了在该匿名类之外定义的对象
 */

public class Parcel9 {
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());      // Tasmania
    }
}
