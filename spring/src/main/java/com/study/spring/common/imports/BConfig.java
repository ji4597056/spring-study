package com.study.spring.common.imports;

import org.springframework.context.annotation.Bean;

/**
 * @author Jeffrey
 * @since 2017/12/02 0:39
 */
public class BConfig {

    @Bean
    public BBean bBean() {
        return new BBean();
    }

    public static class BBean implements Parent{

        public void print() {
            System.out.println("BBean");
        }
    }
}
