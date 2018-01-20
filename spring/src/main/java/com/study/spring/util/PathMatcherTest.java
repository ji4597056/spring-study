package com.study.spring.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;

/**
 * @author Jeffrey
 * @since 2017/12/01 23:46
 */
public class PathMatcherTest {

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Test
    public void isPatternTest() {
        Assert.assertFalse(pathMatcher.isPattern("/1/2/3"));
        Assert.assertFalse(pathMatcher.isPattern("1/2/3"));
    }

    @Test
    public void matchTest() {
        String uri = "/1/2/3";
        Assert.assertTrue(pathMatcher.match("/**", uri));
        Assert.assertTrue(pathMatcher.match("/1/*/3", uri));
        Assert.assertTrue(pathMatcher.match("/1/*/3", uri));
        Assert.assertFalse(pathMatcher.match("1/*/3", uri));
        Assert.assertFalse(pathMatcher.match("/1/2", uri));
        Assert.assertFalse(pathMatcher.match("/1/*/2", uri));
        uri = "/1/2/3?key=123";
        Assert.assertTrue(pathMatcher.match("/**", uri));
        Assert.assertFalse(pathMatcher.match("/1/*/3", uri));
        Assert.assertTrue(pathMatcher.match("/1/2/3?key=*", uri));
        Assert.assertTrue(pathMatcher.match("/1/?/3?key=123", uri));
        Assert.assertTrue(pathMatcher.match("/1/{2}/3?key=**", uri));
        Assert.assertTrue(pathMatcher.match("/1/{2}/{3}?key={key}", uri));
        Assert.assertTrue(pathMatcher.match("/1/{2}/{3}?key*={key}", uri));
    }

    @Test
    public void matchStartTest() {
        String uri = "/1/2/3";
        Assert.assertFalse(pathMatcher.matchStart("/2/3", uri));
        Assert.assertTrue(pathMatcher.matchStart("/1/2/3/4", uri));
        Assert.assertTrue(pathMatcher.matchStart("/1/*/3/**", uri));
        Assert.assertFalse(pathMatcher.matchStart("/0/1/*/3/**", uri));
    }

    @Test
    public void test() {
        String uri1 = "/user/v3/login/123";
        String uri2 = "/user1/v3/login/123";
        String uri3 = "/user1/v3/123";
        String uri4 = "/user/v3/login";
        String uri5 = "/user/1/v3/login";
        String pattern = "/*/v3/login/**";
        Assert.assertTrue(pathMatcher.match(pattern, uri1));
        Assert.assertTrue(pathMatcher.match(pattern, uri2));
        Assert.assertFalse(pathMatcher.match(pattern, uri3));
        Assert.assertTrue(pathMatcher.match(pattern, uri4));
        Assert.assertFalse(pathMatcher.match(pattern, uri5));
    }
}
