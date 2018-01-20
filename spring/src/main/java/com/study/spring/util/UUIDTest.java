package com.study.spring.util;

import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author Jeffrey
 * @since 2017/12/03 0:02
 */
public class UUIDTest {

    @Test
    public void test(){
        IntStream.range(0,10).forEach(i -> System.out.println(UUID.randomUUID()));
    }

}
