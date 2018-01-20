package com.study.spring.common.qualifier;

import com.study.spring.common.qualifier.AConfig.ABean;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AConfig.class)
public class App {

    @MyOwn
    @Autowired
    private List<ABean> myOwnAbeans;

    @Autowired
    private List<ABean> aBeans;

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        App app = context.getBean(App.class);
        Assert.assertEquals(app.aBeans.size(), 2);
        Assert.assertEquals(app.myOwnAbeans.size(), 1);
        Assert.assertEquals(app.myOwnAbeans.get(0).getName(), "my-own");
    }
}