package com.powerjun.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer, String> letterMap = new HashMap<Integer, String>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};


    List<String> convert(int[] digits) {
        List<String> result = new ArrayList<>();
        doConvert("", digits, result, 0);
        return result;
    }

    void doConvert(String combinationStr, int[] digits, List<String> resultList, int index) {
        if (index == digits.length) {
            resultList.add(combinationStr);
        } else {
            String letters = letterMap.get(digits[index]);
            index++;
            if (letters == null) {
                doConvert(combinationStr, digits, resultList, index);
            } else {
                for (int j = 0; j < letters.length(); j++) {
                    doConvert(combinationStr + letters.charAt(j), digits, resultList, index);
                }
            }
        }
    }


}
