package LeetCode._4_String;

import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：_2_Kama54_changeNum
 * @Date：2024/8/28 20:51
 * @Description：给定一个字符串 s，它包含小写字母和数字字符，
 * 请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 */

public class _2_Kama54_changeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.nextLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        for(char c : charArray){
            if(c>='a'&& c<='z'){
                sb.append(c);
            } else if (c>='0' && c<='9') {
                sb.append("number");
            }
        }
        System.out.println(sb.toString());
    }
}
