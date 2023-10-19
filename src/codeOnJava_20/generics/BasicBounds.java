/**
 * 边界的基本要素
 */

package codeOnJava_20.generics;

interface HasColor {
    // 边界中的方法
    java.awt.Color getColor();
}

class WithColor<T extends HasColor> {
    T item;
    WithColor(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    // 可用调用边界中的方法
    java.awt.Color color() {
        return item.getColor();
    }
}


class Coord {
    public int x, y, z;
}

// 在边界中，使用 '&' 连接多个边界，且 类 要放在 接口 前面
// 错误示范：
//- class WithColorCoord<T extends HasColor & Coord> { }


// 多重边界
class WithColorCoord<T extends Coord & HasColor> {
    T item;
    WithColorCoord(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    java.awt.Color color() {
        return item.getColor();
    }

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


interface Weight {
    int weight();
}

// 和使用继承一样，只能继承一个具体类，而可以实现多个接口
class Solid<T extends Coord & HasColor & Weight> {
    T item;
    Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    java.awt.Color color() {
        return item.getColor();
    }
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Coord implements HasColor, Weight {
    @Override
    public java.awt.Color getColor() {
        return null;
    }
    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
