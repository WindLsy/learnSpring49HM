package cn.linshiyou.a06test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author LJ
 * @create 2024/4/17
 */

@Configuration
public class MyConfig {

    private static final Logger log = LoggerFactory.getLogger(MyConfig.class);

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        log.debug("注入 ApplicationContext");
    }

    @PostConstruct
    public void init() {
        log.debug("初始化");
    }

    @Bean //  添加 beanFactory 后处理器
    public BeanFactoryPostProcessor processor() {
        return beanFactory -> {
            log.debug("执行 processor");
        };
    }
}