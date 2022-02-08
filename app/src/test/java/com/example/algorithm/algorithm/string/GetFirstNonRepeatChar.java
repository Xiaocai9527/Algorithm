package com.example.algorithm.algorithm.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiaokun on 2022/1/17.
 *
 * @author xiaokun
 * @date 2022/1/17
 */
class GetFirstNonRepeatChar {

    public static void main(String[] args) {
        System.out.println(getNonRepeatCharacter("aabbccdd"));
        System.out.println(getNonRepeatCharacter("o0kinsigno0m"));
    }

    /**
     * 通过 LinkedHashMap 来记录每个char 出现的次数,
     * 然后循环获取第一个次数为1 的char 即可得出结果
     *
     * @param value
     * @return
     */
    public static Character getNonRepeatCharacter(String value) {
        Map<Character, Integer> integerMap = new LinkedHashMap<>();

        for (int i = 0; i < value.length(); i++) {
            char key = value.charAt(i);
            if (!integerMap.containsKey(key)) {
                integerMap.put(key, 1);
            } else {
                integerMap.put(key, integerMap.get(key) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : integerMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 利用 lastIndexOf == indexOf
     *
     * @param value
     * @return
     */
    public static Character getNonRepeatCharacter1(String value) {
        char[] chars = value.toCharArray();
        for (int i = 0; i < value.length(); i++) {
            char c = chars[i];
            if (value.lastIndexOf(c) == value.indexOf(c)) {
                return c;
            }
        }
        return null;
    }

}
