package com.powerjun.demo;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2020/2/13.
 */
public class DigitConverterTest {

    @Test
    void testConvertWithTwoNormalNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{2, 3});
        Assert.assertEquals(String.join(" ", list), "ad ae af bd be bf cd ce cf");
    }

    @Test
    void testConvertWithSingleNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{9});
        Assert.assertEquals(String.join(" ", list), "w x y z");
    }

    @Test
    void testConvertWithOnlySpecialNum() {
        List<String> list = new DigitConverter().convert(new Integer[]{0});
        Assert.assertEquals(String.join(" ", list), "");
    }

    @Test
    void testConvertWithNull() {
        List<String> list = new DigitConverter().convert(null);
        Assert.assertEquals(String.join(" ", list), "");
    }

    @Test
    void testLetterCombineWith0To99() {
        List<String> list = new DigitConverter().convert(new Integer[]{23});
        Assert.assertEquals(String.join(" ", list), "ad ae af bd be bf cd ce cf");
    }


}