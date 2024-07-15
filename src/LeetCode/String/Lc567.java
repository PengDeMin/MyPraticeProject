package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lc567
 * @Description 字符串的排列(中等)
 * @Author 彭德民 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * @Date 2024/5/2 21:59
 */

public class Lc567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }

    //看s1的排列之一是否是s2的子串
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //1、处理小串的字符和频数，也就是s1
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //valid：在子串和某个滑动窗口串中，双方符合相关条件的字符个数
        int left = 0, right = 0, valid = 0;
        //窗口开始滑动
        while (right < s2.length()) {
            //获取要进去窗口里的字符
            char in = s2.charAt(right);
            //字符匹配处理
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                //此频数若相等满足条件(的字符个数++)
                if (need.get(in).equals(window.get(in))) {
                    valid++;
                }
            }
            //窗口正式右移
            right++;

            //判断窗口左边是否要收缩，滑动窗口和p大小一相等，就要收缩啦
            if (right - left == s1.length()) {
                //只要某一轮匹配上了，说明s1的排列之一就是s2的子串
                //直接返回true
                if (need.size() == valid) {
                    return true;
                }
                char out = s2.charAt(left);
                if (need.containsKey(out)) {
                    if (need.get(out).equals(window.get(out))) {
                        valid--;
                    }
                    window.put(out, window.get(out) - 1);
                }
                //窗口左端正式收缩
                left++;
            }
        }
        //窗口滑动完了都还没有返回，说明寄了呗
        return false;
    }
}
