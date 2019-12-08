package com.canon.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:43
 * @Description:
 */
public class SpringContextUtil implements ApplicationContextAware {


    // spring 应用上下文
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setStaticApplicationContext(applicationContext);
    }

    public static void setStaticApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static<T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static<T> T getBean(String beanName, Class clazz) {
        return (T) applicationContext.getBean(beanName, clazz);
    }
    public static<T> T getBean(String beanName, Object ...  objects) {
        return (T) applicationContext.getBean(beanName, objects);
    }

    public static<T> T getBean(Class clazz, Object ...  objects) {
        return (T) applicationContext.getBean(clazz, objects);
    }

    public static<T> T getBean(Class clazz) {
        return (T) applicationContext.getBean(clazz);
    }

    public static Environment getEnvironment() {
        if (applicationContext != null) {
            return applicationContext.getEnvironment();
        }
        return null;
    }
}
