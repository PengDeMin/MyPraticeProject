package LeetCode.test4399;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName 4399第一题最多改变一个元素位置，将其变为非递减数列
 * @Author Demin Peng
 * @Date 2024/8/12 20:18
 * @Description TODO
 */

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numberArray = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int need = 0;
        for (int i = 1; i <  numberArray.length && need < 2; i++){
            if(numberArray[i-1] <= numberArray[i]){
                continue;
            }
            need++;
            if((i - 2) >= 0 && numberArray[i] < numberArray[i-2]){
                numberArray[i] =  numberArray[i-1];
            }else {
                numberArray[i-1] = numberArray[i];
            }
        }
        System.out.println(need <= 1);
    }
}
