package codeOnJava_11_2;

/**
 * 保存一个对象的序列
 */

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    // 外部类的私有成员可以被内部类访问
    private Object[] items;
    // 外围类的当前位置计数
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    // 迭代器
    private class SequenceSelector implements Selector {
        // 内部类的当前位置计数
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }
        @Override
        public Object current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i<items.length)
                i++;
        }
    }
    // 内部类 SequenceSelector 是私有的，但可以提供一个方法获取内部类对象的引用
    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
