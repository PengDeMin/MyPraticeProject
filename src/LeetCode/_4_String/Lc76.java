package LeetCode._4_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lc76
 * @Description 最小覆盖子串(困难)-滑动窗口思想-经典滑动窗口模版
 * @Author 彭德民
 * @Date 2024/5/2 20:11
 */

public class Lc76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        String res = minWindowCopy(s, p);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        //1、need：记录需要字符及其出现频数，针对目标串t（target）
        //window：滑动窗口，记录字符及其出现频数，针对源串s(source)的一部分
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //2、统计t串中字符频数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //3、设置滑动窗口初始值，记住窗口为左闭右开，这样保证初始没有元素
        //而右边一移动，就会有一个元素
        int left = 0, right = 0;
        int valid = 0;//滑动窗口中满足需要的字符个数，用于后面做判别
        //记录最小覆盖子串的起始索引（0）和初始长度（正常永远娶不到的最大值）
        int start = 0, shortestLen = Integer.MAX_VALUE;
        //滑动窗口右边开始滑动，滑动到源串s末尾才会停下
        while (right < s.length()) {
            char in = s.charAt(right); //开始移动，取得要窗口里添加的字符
            //进行窗口里数据的更新
            if (need.containsKey(in)) {
                //如果源串的这个字符在目标串中，就添加它并记录频数+1
                window.put(in, window.getOrDefault(in, 0) + 1);
                //判断两边的此字符频数一致，说明这个字符双方都满足了
                if (window.get(in).equals(need.get(in))) {
                    //满足条件的字符个数加1，因为是放进来一个
                    valid++;
                }
            }
            //正式扩大窗口
            right++;

            //窗口右边每移动一次，就要判断是否要缩小左边一次

            //判断窗口左边是否需要收缩,如果当前窗口串和目标串符合条件了
            // 左边就要收缩
            while (valid == need.size()) {
                //判断并更新最小子串的长度
                //如果当前满足条件串的长度小于之前的最小子串长度
                // 就更新这个长度并重新设置最小子串的索引开始位置
                if (right - left < shortestLen) {
                    shortestLen = right - left;
                    start = left;
                }
                //取得将要被移出窗口的字符
                char out = s.charAt(left);
                //进行窗口内数据的一系列更新，就是字符频数更新
                if (need.containsKey(out)) {
                    //判断两边的此字符频数一致，说明这个字符双方都满足了
                    if (window.get(out).equals(need.get(out))) {
                        //满足条件的字符个数减1，因为是移出去一个
                        valid--;
                    }
                    //一个字符被移除，窗口内对应的该字符频数自然减1
                    window.put(out, window.get(out) - 1);
                }
                //正式缩小窗口
                left++;
            }
        }

        //while循环结束，说明滑动窗口滑到末尾了，返回结果
        //如果此时shortestLen和合法值，则退出循环时的窗口左端就是最小覆盖子串的开始位置
        //结束位置就是start+shortestLen(最小覆盖子串长度)
        return shortestLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + shortestLen);
    }

    public static String minWindowCopy(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        //处理目标串字符频数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //初始化窗口等参数
        int left = 0, right = 0;
        int start = 0, shortestLen = Integer.MAX_VALUE, valid = 0;

        while (right < s.length()) {
            //准备进去的
            char in = s.charAt(right);
            //更新窗口
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                }
            }
            right++;

            //一旦找到一个覆盖子串，就要看是否需要缩小窗口
            while (need.size() == valid) {
                if (right - left < shortestLen) {
                    shortestLen = right - left;
                    start = left;
                }
                char out = s.charAt(left);
                if (need.containsKey(out)) {
                    if (window.get(out).equals(need.get(out))) {
                        valid--;
                    }
                    window.put(out, window.get(out) - 1);
                }
                left++;
            }
        }
        return shortestLen == Integer.MAX_VALUE ? "" : s.substring(start, start + shortestLen);
    }
}
