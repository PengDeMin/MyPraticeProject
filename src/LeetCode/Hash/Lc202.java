package LeetCode.Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Lc202
 * @Description 快乐数
 * @Author 彭德民 简单
 * @Date 2024/5/3 18:55
 */

public class Lc202 {
    //对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    //然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    //如果这个过程 结果为 1，那么这个数就是快乐数。
    //如果 n 是 快乐数 就返回 true ；不是，则返回 false
    public static void main(String[] args) {
        //System.out.println(isHappy(10));
        System.out.println(isHappy(88));
    }

    public static boolean isHappy(int n) {
        //利用Set元素不可重复的特点
        Set<Integer> set = new HashSet<>();
        //下面这句是核心重点，如果n不是快乐数，则其在不断迭代求各位置数平方和的过程中
        //必然会出现和重复的情况，因为题目提示了不是快乐数时会“无限循环”
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = getSquSum(n);
        }
        //通过n值判断退出循环的原因，等于1说明是快乐数，否则只是因为出现重复值
        return n==1 ? true : false;
    }

    //取出n各个位置的数字并求平方和
     public static int getSquSum(int n){
         int squSum = 0;
         while(n>0){
             squSum += (n%10) * (n%10);
             n /=10 ;
         }
         return squSum;
     }

}
