package LeetCode.ACM_Practice;

import java.util.Scanner;

/**
 * @ClassName printSpecialPicture
 * @Author Demin Peng
 * @Date 2024/9/1 17:06
 * @Description 打印数字图形 kama12 https://kamacoder.com/problempage.php?pid=1011
 * 输入5
 * 输出：
    1
   121
  12321
 1234321
123454321
 1234321
  12321
   121
    1
 */

public class Kama12_printSpecialPicture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //打印增长的上半部分
        for(int i=1;i<=n;i++){
            printARow(i,n);
        }
        //打印缩小的下半部分
        for(int i=n-1;i>0;i--){
            printARow(i,n);
        }
    }

    public static void printARow(int rowMaxNum,int n){
        //打印左边空格
        for(int k=n-rowMaxNum;k>0;k--){
            System.out.print(" ");
        }
        for(int j =1; j<=rowMaxNum;j++){
            System.out.print(j);
        }
        while(--rowMaxNum>0){
            System.out.print(rowMaxNum);
        }
        System.out.println();
    }
}
