package com.study.spring.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

/**
 * @author Jeffrey
 * @since 2017/12/02 23:08
 */
public class ReflectionUtilsTest {

    @Test
    public void test(){
        Field field = ReflectionUtils.findField(Obj.class, "field1");
        System.out.println(field);
        Method method = ReflectionUtils.findMethod(Obj.class, "method1");
        System.out.println(method);
        ReflectionUtils.invokeMethod(method, new Obj());
    }

    public static class Obj {

        private String field1;
        private String field2;
        private String field3;

        public void method1(){
            System.out.println("method1");
        }

        public void method2(){
            System.out.println("method2");
        }
    }
}
