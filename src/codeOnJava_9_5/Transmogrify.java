package codeOnJava_9_5;

/**
 * 通过组合动态的改变对象的行为（状态设计模式）
 *
 * 运行结果：
 * HappyActor
 * SadActor
 *
 */

class Actor {
    public void act() {}
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();     // 向上转型
    public void change() {
        actor = new SadActor();                 // 引用替换
    }
    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

