package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lc3
 * @Description 无重复字符的最长子串(中等)
 * @Author 彭德民  给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * @Date 2024/5/2 22:46
 */

public class Lc3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "aaaaaaa";
        String s2 = "au";
        String s3 = " ";
        String s4 = "a";
        System.out.println(lengthOfLongestSubstring(s4));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int longestLength = 0;//最长子串长度

        while (right < s.length()) {
            //往窗口里放进一个字符串
            char in = s.charAt(right);
            window.put(in, window.getOrDefault(in, 0) + 1);
            //窗口右边移动一下
            right++;

            //一加进来字符就要看是否需要收缩，当出现重复字符就要收缩
            //实际情况是右边没进时窗口内是无重复的，右边一进才会重复，
            // 且重复的就是刚进来的那个字符
            while (window.get(in) > 1) {
                //能进来说明有重复，要收缩左边了
                char out = s.charAt(left);
                window.put(out, window.get(out) - 1);
                left++;
            }
            //while循环结束后说明没有重复子串了，更新当前最长子串长度
//            if(right-left>longestLength){
//                longestLength = right-left;
//            }
            longestLength = Math.max(longestLength, right - left);
        }
        return longestLength;
    }
}
