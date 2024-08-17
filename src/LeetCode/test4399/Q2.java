package LeetCode.test4399;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Q2
 * @Author Demin Peng
 * @Date 2024/8/12 20:36
 * @Description TODO
 */

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numberArray = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        int[] res = twoSum(numberArray,target);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0 || null == nums){
            return res;
        }

        //双指针
        int leftNum = 0, rightNum = 0;
        for(int left = 0, right = nums.length-1; left < right;){
            int sum = nums[left] + nums[right];
            //大了右指针往前走
            if(sum > target){
                --right;
            }
            //小了左指针往后走
            else if(sum < target){
                ++left;
            }
            else{
                leftNum = nums[left];
                rightNum = nums[right];
                break;
            }
        }
        res[0] = leftNum;
        res[1] = rightNum;
        return res;
    }
}
