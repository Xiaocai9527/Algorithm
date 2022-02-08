package com.example.algorithm.algorithm.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by xiaokun on 2022/1/15.
 * 打印出字符串的所有排列
 *
 * @author xiaokun
 * @date 2022/1/15
 */
public class PermutationOfString {

    public static void main(String[] args) {
        Set<String> set = permutationOfString("肖坤是一个大帅哥");
        for (String next : set) {
            System.out.println(next);
        }
    }

    private static Set<String> permutationOfString(String str) {
        HashSet<String> set = new LinkedHashSet<>();
        if (str.length() == 0) {
            //为了最后一个字符串的时候,可以插入最后那个字符到字符串中
            set.add("");
            return set;
        }
        char firstChar = str.charAt(0);
        String remainStr = str.substring(1);
        System.out.println("firstChar:" + firstChar + ";remainStr:" + remainStr + ";length:" + remainStr.length());
        Set<String> permutationForRemain = permutationOfString(remainStr);
        System.out.println("permutationForRemain size:" + permutationForRemain.size()
                + ";permutationForRemain:" + permutationForRemain.toString());
        for (String s : permutationForRemain) {
            for (int i = 0; i <= s.length(); i++) {
                String insertFirstChar = insertFirstChar(s, firstChar, i);
                set.add(insertFirstChar);
            }
        }
        return set;
    }

    private static String insertFirstChar(String str, char firstChar, int index) {
        //把 firstChar 插入到 str 的 index 这个缝里
        // ABC 插入 0 到 index 2 ,结果是 AB0C
        return str.substring(0, index) + firstChar + str.substring(index);
    }


    @Test
    public void testString() {
        String value = "ABC";
        String s = insertFirstChar(value, '0', 2);
        System.out.println(s);

        String substring = "C".substring(1);
        System.out.println(substring + "length:" + substring.length());
    }
}
