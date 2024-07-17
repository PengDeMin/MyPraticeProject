package LeetCode.Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：Three_3_Lc76_hard
 * @Date：2024/7/17 14:07
 * @Description：最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */

public class Three_3_Lc76_hard {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String t = scanner.nextLine();

        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int validType = 0;//双方符合该字符匹配要求的字符种类数
        int minLeft = 0, minRight = 0;
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();

        //统计t中字符及其频数
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        while(right < s.length()){
            char in = s.charAt(right);
            //s串有该字符
            if(tMap.containsKey(in)){
                sMap.put(in, sMap.getOrDefault(in, 0)+1);
                if(tMap.get(in).equals(sMap.get(in))){
                    validType++;
                }
            }
            right++;

            //一旦种类符合要求了，缩小窗口，尽量找出最小长度
            while(validType == tMap.size()){

                //更新最短长度及做好标记
                if(minLen > right-left){
                    minLen = right-left;
                    minLeft = left;
                    minRight = right;
                }

                char out = s.charAt(left);
                if (tMap.containsKey(out)){

                    //两者同一字符的频数相等时，则符合频数的字符种类减一
                    //因为接下来要把这个字符移出去
                    if(tMap.get(out).equals(sMap.get(out))){
                        validType--;
                    }
                    sMap.put(out, sMap.get(out)-1);

                }
                left++;
            }


        }

        //增加Integer.MAX_VALUE ? ""是服务于一个字符也没匹配上的场景
        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(minLeft,minRight);
    }
}
