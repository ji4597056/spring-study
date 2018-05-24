package com.study.spring.common.imports;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jeffrey
 * @since 2018/05/02 14:34
 */
@Configuration
public class PostConfig {

    @Bean
    public FactorcyPostProcessor factorcyPostProcessor() {
        return new FactorcyPostProcessor();
    }

    @Bean
    public PostProcessor postProcessor() {
        return new PostProcessor();
    }

    public static class FactorcyPostProcessor implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(
            ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
            System.out.println("========================");
            System.out.println("调用了BeanFactoryPostProcessor");
            System.out.println("========================");
            String[] beanStr = configurableListableBeanFactory.getBeanDefinitionNames();
            for (String beanName : beanStr) {
                System.out.println("beanName:" + beanName);
            }
        }

    }

    public static class PostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean,
            String beanName) throws BeansException {
            System.out.println("========================");
            System.out.println("后置处理器处理bean=【" + beanName + "】开始");
            System.out.println("========================");
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean,
            String beanName) throws BeansException {
            System.out.println("========================");
            System.out.println("后置处理器处理bean=【" + beanName + "】完毕!");
            System.out.println("========================");
            return bean;
        }
    }
}
