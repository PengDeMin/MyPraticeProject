package LeetCode._1_Array.DualPointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Two_4_Lc977_easy
 * @Description 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @Author 彭德民
 * @Date 2024/7/13 17:52
 */

public class Two_4_Lc977_easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] res = sortedSquares(nums);
        for (int num : res) {
            System.out.print(num + ",");
        }
    }

    //前后双指针，因为平方从大到小的数在数组中时从两端向中间排列的
    private static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        //下面等号不能漏，否则会少处理一个元素
        while (left <= right) {
            res[i--] = Math.abs(nums[left]) <= Math.abs(nums[right]) ?
                    nums[right] * nums[right--] : nums[left] * nums[left++];
        }
        return res;
    }
}
