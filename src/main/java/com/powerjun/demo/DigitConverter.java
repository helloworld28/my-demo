package com.powerjun.demo;


import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * 数字转换器
 * Given an integer array containing digits from [0, 9], the task is to print all possible letter
 * combinations that the numbers could represent. A mapping of digit to letters (just like
 * on the telephone buttons) is being followed. Note that 0 and 1 do not map to any
 * letters. All the mapping are shown in the image below:
 * <p>
 * Created by Administrator on 2020/2/13.
 */
public class DigitConverter {
    Map<Character, String> letterMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    /**
     * 转换方法
     * 1.先把整型数组转为与字符串
     * 2.再进行转换
     *
     * @param digits 整型数组（0-99）
     * @return List<String> 所有组合
     */
    List<String> convert(Integer[] digits) {
        if (digits == null || digits.length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<String> resultList = new ArrayList<>();

        //1.转成字符串
        String digitsStr = transferToStr(digits);

        //2.进行转换
        doConvert("", digitsStr, resultList);

        return resultList;
    }

    private String transferToStr(Integer[] digits) {
        return Arrays.asList(digits)
                .stream()
                .map(String::valueOf)
                .collect(joining());
    }

    /**
     * 实际转换方法
     *
     * @param combinationStr  组合字母
     * @param remainingDigits 剩余数字
     * @param resultList      结果组合列表
     */
    void doConvert(String combinationStr, String remainingDigits, List<String> resultList) {
        if (remainingDigits.length() == 0) {
            resultList.add(combinationStr);
        } else {
            String letters = letterMap.get((Character) remainingDigits.charAt(0));
            remainingDigits = remainingDigits.substring(1);
            if (letters == null) {
                //当前数字不存在字母则直接拼接后面的
                doConvert(combinationStr, remainingDigits, resultList);
            } else {
                //迭代当前数字所有的字母
                for (int j = 0; j < letters.length(); j++) {
                    //递归的方式来拼接后面出现的字字符串
                    doConvert(combinationStr + letters.charAt(j), remainingDigits, resultList);
                }
            }
        }
    }


}
