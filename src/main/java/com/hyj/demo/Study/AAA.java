package com.hyj.demo.Study;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AAA implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("chuchihusawancheng,.......");
    }
}
