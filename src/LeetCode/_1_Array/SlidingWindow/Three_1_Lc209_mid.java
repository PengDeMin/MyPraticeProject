package LeetCode._1_Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：Lc209_mid
 * @Date：2024/7/16 17:31
 * @Description：长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */

public class Three_1_Lc209_mid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = scanner.nextInt();
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0 , right = 0;
        int curSum = 0, minLen = Integer.MAX_VALUE, curlen = 0;
        while (right < nums.length){

            //窗口右边进数，移动，扩大窗口
            curSum += nums[right];
            curlen ++;
            right ++;

            //目前和大于target，则考虑窗口左边滑动，收缩窗口
           if(curSum >= target){
               while(curSum >= target){
                   curSum -= nums[left];
                   curlen --;
                   left++;
               }

               //上一轮while结束时，更新目前的最短长度
               minLen = Math.min(minLen, curlen + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

