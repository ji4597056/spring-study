package com.study.spring.common.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jeffrey
 * @since 2017/12/02 0:39
 */
@Configuration
public class AConfig {

    @Bean
    public ABean aBean() {
        return new ABean("not-my-own");
    }


    @MyOwn
    @Bean
    public ABean aBeanMyOwn() {
        return new ABean("my-own");
    }

    public static class ABean {

        private final String name;

        public ABean(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
