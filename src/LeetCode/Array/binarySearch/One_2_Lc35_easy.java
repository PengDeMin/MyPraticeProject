package LeetCode.Array.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName One_1_Lc35
 * @Description 搜索插入位置（简单）
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Author 彭德民
 * @Date 2024/7/13 11:18
 */

public class One_2_Lc35_easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int target = sc.nextInt();
        int[] nums = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(search(nums, target));

    }

    //左闭右开的写法
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
