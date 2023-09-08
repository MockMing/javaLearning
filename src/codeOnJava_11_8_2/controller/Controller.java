/**
 * 用于控制系统的可复用框架
 */

package codeOnJava_11_8_2.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) {
        eventList.add(c);
    }
    public void run() {
        while(!eventList.isEmpty()) {
            // new ArrayList<>(eventList) -> 创建一个副本，在选择列表中的元素时不会改变列表
            for(Event e : new ArrayList<>(eventList))
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
        }
    }
}
