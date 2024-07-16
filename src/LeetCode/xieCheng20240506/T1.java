package LeetCode.xieCheng20240506;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T1
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/6 19:08
 */

public class T1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //输入n、m
        String nums = scanner.nextLine();
        int[] s = Arrays.stream(nums.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0], m = s[1];
        //输入c1、c2
        String strs = scanner.nextLine();
        //String[] s1 = strs.split(" ");
        char c1 = strs.charAt(0), c2 = strs.charAt(2);

        //遍历n行
        for (int row = 0; row < n; row++) {
            char[] c = new char[m];
            //组装第row行
            for (int col = 0; col < m; col++) {
                if ((row % 2 == 0 && col % 2 == 0) || (row % 2 != 0 && col % 2 != 0)) {
                    c[col] = c1;
                } else {
                    c[col] = c2;
                }

            }
            //输出这一行组装好的字符串
            System.out.println(new String(c));
        }
    }
}
