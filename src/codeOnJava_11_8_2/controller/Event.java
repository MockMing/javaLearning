/**
 * 用于任何控制事件的公共方法
 */

package codeOnJava_11_8_2.controller;

import java.time.*;

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    // 事件构造器，@param millisecondDelay：延后时间，多久以后执行该事件
    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }
    // 事件的预期执行时间 = 当前时间 + 延后时间
    public void start() {
        eventTime = Instant.now().plus(delayTime);
    }
    // 如果已经到了预期时间，则可以执行事件
    // 可以在子类中重写 ready() 让 Event 基于其他因素触发
    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }
    // 具体要做什么在本方法中实现
    public abstract void action();
}
