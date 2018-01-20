package com.study.spring.common.imports;

/**
 * @author Jeffrey
 * @since 2017/12/02 0:39
 */
public class CConfig {

    public CBean cBean() {
        return new CBean();
    }

    public static class CBean implements Parent{

        public void print() {
            System.out.println("CBean");
        }
    }
}
