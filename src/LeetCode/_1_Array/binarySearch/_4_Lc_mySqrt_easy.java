package LeetCode._1_Array.binarySearch;

import java.util.Scanner;

/**
 * @ClassName One_4_Lc_easy
 * @Description x 的平方根(简单，其实并不简单)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @Author 彭德民
 * @Date 2024/7/13 14:41
 */

public class _4_Lc_mySqrt_easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(mySqrt(x));
    }

    private static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //由于利用相乘来计算会导致数据溢出，因此计算相除
            // int temp = mid*mid;
            if (x / mid == mid) {
                //说明此x的算术平方根是整数，因此能在{1,2,3...x}的有序序列中找到这个数
                return mid;
            } else if (x / mid < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //while循环走完说明此x的算术平方根数字是小数，
        // 且此时left为其在{1,2,3....,x}这个有序数列中应该插入的位置
        //因此离它最近的整数就是所插入位置-1；
        return left - 1;
    }
}
