package codeOnJava_10_2_3;

class Heat implements Operation {
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}
public class MetalWork {
    public static void main(String[] args) {
        // 必须在静态上下文中定义才能使用方法引用
        // 在静态上下文中，“实例化”一个接口对象，同时重写所需的方法
        Operation twist = new Operation() {
            @Override
            public void execute() {
                Operation.show("Twist");
            }
        };
        Operation.runOps(
                new Heat(),                                 // 常规类
                new Operation() {                           // 匿名类
                    @Override
                    public void execute() {
                        Operation.show("Hammer");
                    }
                },
                // twist::execute,  *被限定符替代为下一行了
                twist,                                      // 方法引用
                () -> Operation.show("Anneal")         // lambda 表达式
        );
    }
}
