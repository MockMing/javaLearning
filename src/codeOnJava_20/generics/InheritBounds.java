/**
 * 每一层继承也会增加边界的限制
 */

package codeOnJava_20.generics;

class HoldItem<T> {
    T item;
    HoldItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}

// 泛型的边界有了新的限制，类中实现它，重复的内容直接从基类继承而无需再写一遍
class WithColor2<T extends HasColor> extends HoldItem<T> {
    WithColor2(T item) {
        super(item);
    }
    // 新的可调用的成员
    java.awt.Color color() {
        return item.getColor();
    }
}

class WithColorCoord2<T extends Coord & HasColor> extends WithColor2<T> {
    WithColorCoord2(T item) {
        super(item);
    }
    // 新的可调用的成员
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }
}

class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoord2<T> {
    Solid2(T item) {
        super(item);
    }
    // 新的可调用的成员
    int weight() {
        return item.weight();
    }
}


public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
