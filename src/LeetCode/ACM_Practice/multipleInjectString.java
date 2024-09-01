package LeetCode.ACM_Practice;

import java.util.Scanner;

/**
 * @ClassName multipleInjectString
 * @Author Demin Peng
 * @Date 2024/9/1 16:31
 * @Description ACM输入输出模版练习-多行数据，每一行均为一个字符串
 */

public class multipleInjectString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 多组测试样例，每组输⼊数据为字符串，字符⽤空格分隔,
        A B C D F
        B F F C C A
        D C E F
         */
        while(sc.hasNextLine()){
            String[] items = sc.nextLine().split(" ");
            for(String item:items){
                System.out.println(item);
            }
        }



    }
}
