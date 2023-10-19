/**
 * 栈类
 * 可以不使用 LinkList 实现中定义地内部链式存储机制
 */

package codeOnJava_20.generics;

public class LinkedStack<T> {

    // 内部类
    private static class Node<U> {
        U item;         // （Node 作为容器的任务）指向节点内保存的信息，可以通过 top.item 取得保存的信息
        Node<U> next;   // 指向下个节点
        Node() {
            item = null;
            next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();         // 末端哨兵

    public void push(T item) {
        top = new Node<>(item, top);            // 传入当前栈顶
    }

    public T pop() {
        T result = top.item;
        if(!top.end())      // 如果存在下个节点，就将栈顶后移
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();      // 初始化 lss 时，top 也会完成初始化
        for(String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while((s = lss.pop()) != null)
            System.out.println(s);
    }
}
