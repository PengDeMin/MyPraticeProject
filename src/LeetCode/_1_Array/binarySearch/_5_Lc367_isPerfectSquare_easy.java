package LeetCode._1_Array.binarySearch;

import java.util.Scanner;

/**
 * @ClassName One_5_Lc_easy
 * @Description 有效的完全平方数
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * @Author 彭德民
 * @Date 2024/7/13 15:44
 */

public class _5_Lc367_isPerfectSquare_easy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isPerfectSquare(num));
    }

    //很简单，如果一个数是完全平方数，则一定可以在{1,2,3,4....,num}的有序数列中
    //通过二分查找定位到这个数
    private static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int left = 0;
        int right = num;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //由于利用相乘来计算会导致数据溢出，因此计算相除
            // int temp = mid*mid;
            //为了防止5/2=2从而判定5是有效完全平方数
            if (num / mid == mid && num % mid == 0) {
                //说明此num的算术平方根是整数，因此能在{1,2,3...num}的有序序列中找到这个数
                return true;
            } else if (num / mid < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}


