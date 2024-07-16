package LeetCode.Array.DualPointers;

import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：Two_6_Lc844_easy
 * @Date：2024/7/16 11:30
 * @Description：比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 */

public class Two_6_Lc844_easy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(backspaceCompare2(s,t));
    }



    /**
     * @Description 使用栈的思想，多加一个StringBuilder去重构字符串，再把两个StringBuilder对比
     * 消耗内存才击败7.86%的人,时间复杂度和空间复杂度都是O(N+M)
     * @Date 2024/7/16 15:06
     * @Param [s, t]
     * @Return boolean
     **/
    public static boolean backspaceCompare(String s, String t){

        if(s.equals(t) || (null == s && null == t)){
            return true;
        }

        String sbs = getHandledStr(s);
        String sbt = getHandledStr(t);
        if(sbs.equals(sbt)){
            return true;
        }else {
            return false;
        }

    }

    private static String getHandledStr(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)!='#'){
                sb.append(str.charAt(i));
            }
            else if(!sb.toString().isEmpty()){
                sb.delete(sb.length()-1, sb.length());
            }
        }
        return sb.toString();
    }


    /**
     * @Description 双指针思想
     * 由于‘#’只会影响前面的字符，不会影响后面的字符，因此我们逆序地遍历字符串
     * 时间复杂度O(N+M)，空间复杂度是O(1)
     * @Date 2024/7/16 15:08
     * @Param [s, t]
     * @Return boolean
     **/
    public static boolean backspaceCompare2(String s, String t) {

        int sSkip = 0;
        int tSkip = 0;
        int si = s.length()-1;
        int ti = t.length()-1;

        while(si>=0 || ti>=0){
            //小面这个小循环结束在从后往前第一个还没比较的字符处
            while(si>=0){
                if(s.charAt(si)=='#'){
                    sSkip++;//前面要跳跃字符加1
                    si--;
                } else if (sSkip>0) {
                    sSkip--;//前面要跳跃字符减1
                    si--;
                }else {
                    break;//跳出s这边的小循环
                }
            }

            //小面这个小循环结束在从后往前第一个还没比较的字符处
            while(ti>=0){
                if(t.charAt(ti)=='#'){
                    tSkip++;//前面要跳跃字符加1
                    ti--;
                } else if (tSkip>0) {
                    tSkip--;//前面要跳跃字符减1
                    ti--;
                }else {
                    break;//跳出s这边的小循环
                }
            }

            //进入大循环此轮的比较
            if(si >= 0 && ti >=0){
                if (s.charAt(si) != t.charAt(ti)){
                    return false;
                }
            }else {
                //一个还有字符没比完，但另一个字符已经比完了，则肯定不匹配
                if (si >= 0 || ti >= 0) {
                    return false;
                }
            }

            si--;
            ti--;
        }
    return true;
    }
}
