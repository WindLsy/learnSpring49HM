package com.itheima.a04;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/*
    bean 后处理器的作用
 */
public class A04 {
    public static void main(String[] args) {
        // ⬇️GenericApplicationContext 是一个【干净】的容器
        GenericApplicationContext context = new GenericApplicationContext();

        // ⬇️用原始方法注册三个 bean
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.registerBean("bean4", Bean4.class);

        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());// 负责获取 @Value 的值，解析 @Qualifier、泛型、@Lazy 等
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class); // 解析 @Autowired @Value(依赖注入阶段)

        context.registerBean(CommonAnnotationBeanPostProcessor.class); // @Resource (依赖注入阶段) @PostConstruct (初始化前) @PreDestroy (销毁前)

        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory()); // ConfigurationProperties (初始化前)

        // ⬇️初始化容器
        context.refresh(); // 执行beanFactory后处理器, 添加bean后处理器, 初始化所有单例

        System.out.println(context.getBean(Bean1.class));

        // ⬇️销毁容器
        context.close();

        /*
            学到了什么
                a. @Autowired 等注解的解析属于 bean 生命周期阶段(依赖注入, 初始化)的扩展功能
                b. 这些扩展功能由 bean 后处理器来完成
         */
    }
}
