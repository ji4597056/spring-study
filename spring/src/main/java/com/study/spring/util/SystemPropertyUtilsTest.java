package com.study.spring.util;

import org.junit.Test;
import org.springframework.util.SystemPropertyUtils;

/**
 * @author Jeffrey
 * @since 2017/12/02 22:27
 */
public class SystemPropertyUtilsTest {

    @Test
    public void test() {
        final String origin = "key is ${key:123}";
        String text = origin;
        System.out.println(SystemPropertyUtils.resolvePlaceholders(text, true));
        System.out.println(SystemPropertyUtils.resolvePlaceholders(text));
        System.setProperty("key", "456");
        System.out.println(SystemPropertyUtils.resolvePlaceholders(text));
    }

}
