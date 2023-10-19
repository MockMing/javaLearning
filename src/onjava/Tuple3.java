/**
 * 更长的元组可以通过继承实现
 */

package onjava;

public class Tuple3<A, B, C> extends Tuple2<A, B>{
    private final C c;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }
    @Override
    public String rep() {
        return super.rep() + ", " + c;
    }
}
