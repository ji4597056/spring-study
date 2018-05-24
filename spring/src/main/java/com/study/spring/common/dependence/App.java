package com.study.spring.common.dependence;

import javax.annotation.PostConstruct;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Jeffrey
 * @since 2018/05/21 11:18
 */
public class App {

    ApplicationContext context;

    @Configuration
    @Import({ABean.class, BBean.class})
    public static class Config1 {

    }

    @Test
    public void test1() {
        setContext(Config1.class);
        Assert.assertNotNull(context.getBean(ABean.class).getbBean());
        Assert.assertNotNull(context.getBean(BBean.class).getaBean());
        Assert.assertSame(context.getBean(ABean.class).getbBean(), context.getBean(BBean.class));
    }

    @Configuration
    @Import({CBean.class, DBean.class, EBean.class})
    public static class Config2 {

    }

    @Test
    public void test2() {
        setContext(Config2.class);
        Assert.assertNotNull(context.getBean(CBean.class).getdBean());
        Assert.assertNotNull(context.getBean(DBean.class).geteBean());
        Assert.assertNotNull(context.getBean(EBean.class).getcBean());
    }

    @Configuration
    @Import({ABean.class, BBean.class, HBean.class})
    public static class Config3 {

    }

    @Test
    public void test3() {
        setContext(Config3.class);
        Assert.assertNotNull(context.getBean(ABean.class).getbBean());
        Assert.assertNotNull(context.getBean(BBean.class).getaBean());
        Assert.assertNotNull(context.getBean(HBean.class).getaBean());
        Assert.assertNotNull(context.getBean(HBean.class).getbBean());
    }

    @Configuration
    @Import({FBean.class, GBean.class})
    public static class Config4 {

    }

    @Test
    public void test4() {
        boolean result = false;
        try {
            setContext(Config4.class);
            context.getBean(FBean.class).getgBean();
            context.getBean(GBean.class).getfBean();
        } catch (Exception e) {
            e.printStackTrace();
            result = true;
            Assert.assertNotNull(e);
        }
        Assert.assertTrue(result);
    }

    @Configuration
    @Import({IBean.class, JBean.class})
    public static class Config5 {

    }

    @Test
    public void test5() {
        boolean result = false;
        try {
            setContext(Config5.class);
            context.getBean(IBean.class).getjBean();
            context.getBean(JBean.class).getiBean();
        } catch (Exception e) {
            e.printStackTrace();
            result = true;
            Assert.assertNotNull(e);
        }
        Assert.assertTrue(result);
    }

    @Configuration
    @Import({KBean.class, LBean.class})
    public static class Config6 {

    }

    @Test
    public void test6() {
        setContext(Config6.class);
        Assert.assertNotNull(context.getBean(KBean.class).getlBean());
        Assert.assertNotNull(context.getBean(LBean.class).getkBean());
    }

    @Configuration
    @Import({MBean.class, NBean.class})
    public static class Config7 {

    }

    @Test
    public void test7() {
        setContext(Config7.class);
        Assert.assertNotNull(context.getBean(MBean.class).getnBean());
        Assert.assertNotNull(context.getBean(NBean.class).getmBean());
        Assert.assertNotSame(context.getBean(MBean.class).getnBean(), context.getBean(NBean.class));
        System.out.println(context.getBean(MBean.class).getnBean().toString());
    }

    @Configuration
    @Import({OBean.class, PBean.class})
    public static class Config8 {

    }

    @Test
    public void test8() {
        boolean result = false;
        try {
            setContext(Config8.class);
            context.getBean(OBean.class).getpBean();
            context.getBean(PBean.class).getoBean();
        } catch (Exception e) {
            e.printStackTrace();
            result = true;
            Assert.assertNotNull(e);
        }
        Assert.assertTrue(result);
    }

    // ABean
    @Component
    public static class ABean {

        @Autowired
        private BBean bBean;

        @PostConstruct
        public void init() {
            System.out.println("ABean!");
        }

        public BBean getbBean() {
            return bBean;
        }
    }

    // BBean
    @Component
    public static class BBean {

        @Autowired
        private ABean aBean;

        public ABean getaBean() {
            return aBean;
        }
    }

    // CBean
    @Component
    public static class CBean {

        @Autowired
        private DBean dBean;

        public DBean getdBean() {
            return dBean;
        }
    }

    // DBean
    @Component
    public static class DBean {

        @Autowired
        private EBean eBean;

        public EBean geteBean() {
            return eBean;
        }
    }

    // EBean
    @Component
    public static class EBean {

        @Autowired
        private CBean cBean;

        public CBean getcBean() {
            return cBean;
        }
    }

    // FBean
    @Component
    public static class FBean {

        private GBean gBean;

        @Autowired
        public FBean(GBean gBean) {
            this.gBean = gBean;
        }

        public GBean getgBean() {
            return gBean;
        }
    }

    // GBean
    @Component
    public static class GBean {

        private FBean fBean;

        @Autowired
        public GBean(FBean fBean) {
            this.fBean = fBean;
        }

        public FBean getfBean() {
            return fBean;
        }
    }

    // HBean
    @Component
    public static class HBean {

        private ABean aBean;

        private BBean bBean;

        @Autowired
        public HBean(ABean aBean, BBean bBean) {
            this.aBean = aBean;
            this.bBean = bBean;
        }

        public ABean getaBean() {
            return aBean;
        }

        public BBean getbBean() {
            return bBean;
        }
    }

    // IBean
    @Component
    @Scope("prototype")
    public static class IBean {

        @Autowired
        private JBean jBean;

        public JBean getjBean() {
            return jBean;
        }
    }

    // JBean
    @Component
    @Scope("prototype")
    public static class JBean {

        @Autowired
        private IBean iBean;

        public IBean getiBean() {
            return iBean;
        }
    }

    // KBean
    @Component
    @Scope("prototype")
    public static class KBean {

        @Autowired
        private LBean lBean;

        public LBean getlBean() {
            return lBean;
        }
    }

    // LBean
    @Component
    public static class LBean {

        @Autowired
        private KBean kBean;

        public KBean getkBean() {
            return kBean;
        }
    }

    // MBean
    @Component
    public static class MBean {

        private NBean nBean;

        @Autowired
        @Lazy
        public MBean(NBean nBean) {
            this.nBean = nBean;
        }

        public NBean getnBean() {
            return nBean;
        }
    }

    // NBean
    @Component
    public static class NBean {

        private MBean mBean;

        @Autowired
        @Lazy
        public NBean(MBean mBean) {
            this.mBean = mBean;
        }

        public MBean getmBean() {
            return mBean;
        }
    }

    // OBean
    @Component
    public static class OBean {

        private PBean pBean;

        @Autowired
        @Lazy
        public OBean(PBean pBean) {
            this.pBean = pBean;
            System.out.println(pBean.toString());
        }

        public PBean getpBean() {
            return pBean;
        }
    }

    // PBean
    @Component
    public static class PBean {

        private OBean oBean;

        @Autowired
        @Lazy
        public PBean(OBean oBean) {
            this.oBean = oBean;
            System.out.println(oBean.toString());
        }

        public OBean getoBean() {
            return oBean;
        }
    }

    private void setContext(Class config) {
        context = new AnnotationConfigApplicationContext(config);
    }
}
