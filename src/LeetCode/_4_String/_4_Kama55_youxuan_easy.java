package LeetCode._4_String;

import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：temp
 * @Date：2024/8/29 19:46
 * @Description：
 * /**
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。
 * 给定一个字符串 s 和一个正整数 k，请编写一个函数，
 * 将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 */

public class _4_Kama55_youxuan_easy {

    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        char[] charArray = sc.next().toCharArray();

        //1、先整体翻转
        reverse(charArray,0,charArray.length-1);

        //2、翻转前k个字符
        reverse(charArray,0,k-1);

        //3、翻转后面的字符
        reverse(charArray,k,charArray.length-1);

        System.out.println(new String(charArray));
    }

    public static void reverse(char[] charArray, int left, int right){

        while(left < right){
            charArray[left] ^= charArray[right];
            charArray[right] ^= charArray[left];
            charArray[left++] ^= charArray[right--];
        }
    }
}
