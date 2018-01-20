package com.study.spring.common.imports;

import com.study.spring.common.imports.AConfig.ABean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    ApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfig.class);

    @Test
    public void testABean() {
        Assert.assertNotNull(context.getBean("aBean"));
    }

    @Test
    public void testBBean() {
        Assert.assertNotNull(context.getBean("bBean"));
    }

    @Test(expected = Exception.class)
    public void testCBean() {
        context.getBean("cBean");
    }

    @Test
    public void testPost(){
        context.getBean("aBean", ABean.class).print();
    }
}