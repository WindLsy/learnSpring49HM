package com.itheima.a01;

import org.springframework.context.ApplicationEvent;

/**
 * 只用于事件注册
 */
public class UserRegisteredEvent extends ApplicationEvent {
    public UserRegisteredEvent(Object source) {
        super(source);
    }
}
