package LeetCode.Array.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName One_3_Lc34
 * @Description 在排序数组中查找元素的第一个和最后一个位置（中等）
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * @Author 彭德民
 * @Date 2024/7/13 11:30
 */

public class One_3_Lc34_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.next().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = sc.nextInt();
        int[] res = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        System.out.println(res[0] + "," + res[1]);
    }

    //左闭右开的写法
    private static int binarySearch(int[] nums, int target, boolean isFindLeft) {
        int left = 0;
        int right = nums.length;
        int boundary = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                boundary = mid;
                //找左边界
                if (isFindLeft) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return boundary;
    }
}
