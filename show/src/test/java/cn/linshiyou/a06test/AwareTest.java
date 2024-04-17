package cn.linshiyou.a06test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;


/**
 * Aware接口测试
 *
 * @author LJ
 * @create 2024/4/17
 */
public class AwareTest {

    private static final Logger log = LoggerFactory.getLogger(AwareTest.class);

    public static void main(String[] args) {

        // 初始化一个空容器
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("myBean", MyBean.class);
//        context.registerBean("myConfig", MyConfig.class);
        // 注册bean后处理器 解析 @Autowired
//        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        // 注册bean后处理器 解析 @PostConstruct、@PreDestroy 等注解。
//        context.registerBean(CommonAnnotationBeanPostProcessor.class);
//        context.registerBean(ConfigurationClassPostProcessor.class);

        // 刷新上下文：处理beanFactory、bean并完成实例化
        context.refresh();
        context.close();
    }
}