package LeetCode;

import java.util.Scanner;

/**
 * @ClassName wangyiT2
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/20 20:22
 */

public class wangyiT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int[] aNeed = new int[n];
        int[] bNeed = new int[n];
        int[] cNeed = new int[n];
        int[] profit = new int[n];
        int maxAllProfit = 0;
        for (int i = 0; i < n; i++) {
            aNeed[i] = scanner.nextInt();
            bNeed[i] = scanner.nextInt();
            cNeed[i] = scanner.nextInt();
            profit[i] = scanner.nextInt();
        }


    }
}
