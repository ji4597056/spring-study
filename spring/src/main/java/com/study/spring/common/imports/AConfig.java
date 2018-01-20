package com.study.spring.common.imports;

import javax.annotation.PostConstruct;
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
        return new ABean();
    }

    public static class ABean implements Parent{

        @PostConstruct
        public void init(){
            System.out.println("=====================");
            System.out.println("ABean init!");
            System.out.println("=====================");
        }

        public void print() {
            System.out.println("ABean");
        }
    }
}
