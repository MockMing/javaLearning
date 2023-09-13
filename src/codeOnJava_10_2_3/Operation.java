package codeOnJava_10_2_3;

public interface Operation {
    void execute();
    // 操作该接口的方法
    static void runOps(Operation... ops) {
        for(Operation op : ops)
            op.execute();
    }
    // 通用工具
    static void show(String msg) {
        System.out.println(msg);
    }
}
