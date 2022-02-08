package com.example.algorithm.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaokun on 2022/2/8.
 *
 * @author xiaokun
 * @date 2022/2/8
 */
class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                return Math.max(1, max);
            }
            Set<Character> characterSet = new HashSet<>();
            characterSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                boolean add = characterSet.add(s.charAt(j));
                max = Math.max(max, characterSet.size());
                if (!add) {
                    break;
                }
            }
        }
        return max;
    }

}
