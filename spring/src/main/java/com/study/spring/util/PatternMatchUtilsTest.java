package com.study.spring.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.PatternMatchUtils;

/**
 * @author Jeffrey
 * @since 2017/12/02 23:21
 */
public class PatternMatchUtilsTest {

    @Test
    public void test(){
        Assert.assertTrue(PatternMatchUtils.simpleMatch("abc", "abc"));
        Assert.assertTrue(PatternMatchUtils.simpleMatch("*abc*", "abc"));
        Assert.assertTrue(PatternMatchUtils.simpleMatch("*abc**", "abc"));
        Assert.assertFalse(PatternMatchUtils.simpleMatch("*abc*abc", "abc"));
        Assert.assertTrue(PatternMatchUtils.simpleMatch("*abc*abc", "abcbabc"));
    }

}
