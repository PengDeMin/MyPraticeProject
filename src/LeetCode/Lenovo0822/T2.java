package LeetCode.Lenovo0822;

import java.util.Scanner;

/**
 * @ClassName T2
 * @Author Demin Peng
 * @Date 2024/8/22 21:50
 * @Description TODO
 */

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        int okNum = 0;

        for (int i = 0; i < inStr.length(); i++) {
            for(int j = i+1; j < inStr.length()+1; j++) {
                String subStr = inStr.substring(i, j);
                if(isDivisible(subStr)){
                    okNum++;
                }
            }
        }
        System.out.println(okNum);
    }

    public static boolean isDivisible(String subStr) {
        //将该字符串变成数字
        int num = Integer.parseInt(subStr);
        if (num % 4 == 0) {
            return true;
        }
        return false;
    }
}
