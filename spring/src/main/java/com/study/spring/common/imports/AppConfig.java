package com.study.spring.common.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Jeffrey
 * @since 2017/12/02 0:44
 */
@Configuration
@Import({AConfig.class,BConfig.class,CConfig.class})
public class AppConfig {

}
