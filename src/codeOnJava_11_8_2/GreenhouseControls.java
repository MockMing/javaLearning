package codeOnJava_11_8_2;

import codeOnJava_11_8_2.controller.Controller;
import codeOnJava_11_8_2.controller.Event;

public class GreenhouseControls extends Controller {

    // 灯 控制
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // 将硬件控制代码放在这里，实际上打开灯
            light = true;
        }
        @Override
        public String toString() {
            return "Light is on";
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            // 将硬件控制代码放在这里，实际上关闭灯
            light = false;
        }
        @Override
        public String toString() {
            return "Light is off";
        }
    }

    // 水 控制 和灯控制没区别
    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = true;
        }
        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = false;
        }
        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    // 响铃 控制器 每次发生后，再次以相同的时间间隔发生相同事件
    // action() 的一个例子，向事件列表中插入一个新的相同事件
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime.toMillis()));
        }
        @Override
        public String toString() {
            return "Bing!";
        }
    }

    // 重新运行所有事件（仅限在 eventList 中的事件）
    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(var e : eventList)
                addEvent(e);
        }
        // 如果在本 action() 中加入一个 Restart 对象，系统就可以实现定期重启
        @Override
        public void action() {
            for(var e : eventList) {
                e.start();      // 重新运行每个事件
                addEvent(e);
            }
            start();        // 重新运行该事件
            addEvent(this);
        }
        @Override
        public String toString() {
            return " - Restarting system - ";
        }
    }

    // 关闭系统
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.exit(0);
        }
        @Override
        public String toString() {
            return " - Terminating - ";
        }
    }
}
