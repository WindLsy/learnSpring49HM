package com.itheima.a06test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * Aware接口测试
 *
 * @author LJ
 * @create 2024/4/17
 */
public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(MyBean.class);
    @Override
    public void setBeanName(String name) {
        log.debug("1. 当前bean : " + this + " 名字叫:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("2. 当前bean : " + this + " 容器是:" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("3. 当前bean : " + this + " 初始化完成");
    }

    /**
     * 尝试使用 @Autowired 代替 ApplicationContextAware 接口
     * @param applicationContext
     */
    @Autowired
    public void aaa(ApplicationContext applicationContext) {
        log.debug("@Autowired 当前bean : " + this + " 容器是:" + applicationContext);
    }

    /**
     * 尝试使用 @PostConstruct 代替 InitializingBean 接口
     */
    @PostConstruct
    public void init() {
        log.debug("@PostConstruct ：当前bean : " + this + " 初始化完成");
    }
}
