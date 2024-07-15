package LeetCode.yuxin20240613;

import java.util.Scanner;

/**
 * @ClassName T12
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/13 10:58
 */

public class T12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //接收字符串
        char[] cArray = in.nextLine().toCharArray();
        String yuanString = "aeiou";
        int yuanCount = 0;
        int fuCount = 0;
        //遍历字符串
        for(char c : cArray){
            //如果是元音字母则元音字母个数加1
            if(yuanString.indexOf(c)>-1){
                yuanCount+=1;
            }
        }
        //统计辅音字母个数
        fuCount = cArray.length-yuanCount;
        //使用贪心算法估计最长合法单词长度
        int maxWordLen = Math.min(yuanCount+1,fuCount)+yuanCount;
        System.out.println(maxWordLen);
    }
}
