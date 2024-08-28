package LeetCode._4_String;

import java.util.Arrays;

/**
 * @Author：彭德民
 * @ClassName：t31
 * @Date：2024/8/28 21:58
 * @Description：翻转字符串里的单词（中等）的练习版本
 */

public class _3_1_LC151_copy {
    public static void main(String[] args) {
        System.out.println(reverseWords(" 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU"));
    }

    public static String reverseWords(String s) {
        //1、去除字符串中多余的空格
        char[] tempChar = new char[s.length()];
        int index=0;
        int start = 0,end = s.length()-1;
        //去除首尾的空格字符
        while(s.charAt(start)==' '){
            start++;
        }
        while(s.charAt(end)==' '){
            end--;
        }
        //去除中间的多余空格，并放入暂存字符数组
        while(start<=end){
            if(s.charAt(start)!=' '|| tempChar[index-1] != ' '){
                tempChar[index++] = s.charAt(start);
            }
            start++;
        }

        //2、整体翻转
        reverseString(tempChar,0,index-1);

        //3、翻转各个单词
        int left = 0;
        int right = 1;
        while(left<index){
            while(right<index && tempChar[right]!=' '){
                right++;
            }
            reverseString(tempChar,left,right-1);
            left = right+1;
            right = left+1;
        }

        return new String(Arrays.copyOfRange(tempChar,0,index));

    }

    public static void reverseString(char[] tempChar,int left,int right){
        while(left<right){
            char a = tempChar[left];
            tempChar[left++] = tempChar[right];
            tempChar[right--] = a;
//            tempChar[left] ^= tempChar[right];
//            tempChar[right] ^= tempChar[left];
//            tempChar[left++] ^= tempChar[right--];
        }
    }
}
