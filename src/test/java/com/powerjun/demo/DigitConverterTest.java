package com.powerjun.demo;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/2/13.
 */
public class DigitConverterTest {

    @Test
    void testConvertWithTwoNormalNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{2, 3});
        String actual = list.stream().collect(Collectors.joining(" "));
        Assert.assertEquals(actual, "ad ae af bd be bf cd ce cf");
    }

    @Test
    void testConvertWithSingleNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{9});
        String actual = list.stream().collect(Collectors.joining(" "));
        Assert.assertEquals(actual, "w x y z");
    }

    @Test
    void testConvertWithOnlySpecialNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{0});
        String actual = list.stream().collect(Collectors.joining(" "));
        Assert.assertEquals(actual, "");
    }

    @Test
    void testLetterCombineWith0To99() {
        List<String> list = new DigitConverter().convert(new Integer[]{23});
        String actual = list.stream().collect(Collectors.joining(" "));
        Assert.assertEquals(actual, "ad ae af bd be bf cd ce cf");
    }


}