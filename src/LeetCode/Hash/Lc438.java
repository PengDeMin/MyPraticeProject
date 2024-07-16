package LeetCode.Hash;

import java.util.*;

/**
 * @ClassName Lc438
 * @Description 找到字符串中所有字母异位词（中等）-滑动窗口思想
 * @Author 彭德民
 * @Date 2024/5/2 16:01
 */

public class Lc438 {
    public static void main(String[] args) {
        //题目说了s和t仅包含小写字母
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams3(s, p);
        System.out.println(res);
    }

    //最笨的滑动窗口
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return res;
        }

        //1、统计p中的字母频数
        int[] freRercord = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freRercord[p.charAt(i) - 'a']++;
        }

        //2、处理母串s,每次for循环处理一个p长度的部分
        for (int i = 0; (i + p.length()) <= s.length(); i++) {
            //这里如果不用freRercord.clone()而直接是int[] tmpRercord = freRercord
            //则由于java的字符串常量池设置，tmpRercord和freRecord两个引用指向同一个对象
            //因此修改了tmpRercord[x]也就修改了里面的那个唯一的对象。
            int[] tmpRercord = freRercord.clone();
            boolean flag = true;
            //看当前位置到p长度之间的部分与p是否互为异位词
            for (int j = i; j < i + p.length(); j++) {
                tmpRercord[s.charAt(j) - 'a']--;
            }
            for (int fre : tmpRercord) {
                if (fre != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    //官方题解1的滑动窗口
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int sLength = s.length(), pLength = p.length();
        if (sLength < pLength) {
            return res;
        }

        int[] freS = new int[26], freP = new int[26];
        //1、统计小串p的字母频数，顺带统计大串S最开始的长度为pLength部分的字母频数
        for (int i = 0; i < pLength; i++) {
            ++freP[p.charAt(i) - 'a'];
            ++freS[s.charAt(i) - 'a'];
        }
        //先比较首端的部分，能匹配上就放进去
        if (Arrays.equals(freS, freP)) {
            res.add(0);
        }
        //2、进入滑动窗口模式
        for (int i = 0; i < sLength - pLength; i++) {
            --freS[s.charAt(i) - 'a'];//减去窗口左端的字母频数，用于下面与freP比较
            ++freS[s.charAt(i + pLength) - 'a'];//记录窗口右侧下一处的字母频数，用于下一轮与freP比较

            //由上可知，每次循环进来的i先减减，是把第i轮的滑动窗口消除掉，因为第i轮在上一轮（i-1）轮已经比较过了
            //然后i+plenght加加，是把第i+1轮的滑动窗口内的字母频数统计起来，用于下面的比较
            if (Arrays.equals(freS, freP)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    //labuladong的滑动窗口代码模版
    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //2、统计t串中字符频数
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //初始化窗口等参数
        int left = 0, right = 0, valid = 0;
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

            //判断左侧是否要收窄,当窗口长度等于p长度
            if (right - left == p.length()) {
                //判断这一轮窗口的字符频数与p字符频数是否一致，看valid
                //need.size主要成了被动比较的对象
                if (need.size() == valid) {
                    res.add(left);
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
        return res;
    }
}
