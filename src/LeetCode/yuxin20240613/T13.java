package LeetCode.yuxin20240613;

import java.util.*;

/**
 * @ClassName T13
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/13 11:19
 */

public class T13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Integer[] costPrice = new Integer[n];
        Integer[] sellPrice = new Integer[n];
        Integer[] profitPrice = new Integer[n];

        //输入n个菜的信息
        for (int i = 0; i < n; i++) {
            //记录菜品的本金和售卖价格
            costPrice[i] = in.nextInt();
            sellPrice[i] = in.nextInt();
            profitPrice[i] = sellPrice[i] - costPrice[i];
        }

        int sellTotal = 0;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            int thisProfit = 0;
            for (int j = i + 1; j < n; j++) {
                if ((sellTotal + sellPrice[j]) <= m) {
                    sellTotal += sellPrice[j];
                    thisProfit += (sellPrice[j] - costPrice[j]);
                }
            }
            if (thisProfit > maxProfit) {
                maxProfit = thisProfit;
            }
        }

        //输出最大餐馆营利
        System.out.println(maxProfit);
    }
}
