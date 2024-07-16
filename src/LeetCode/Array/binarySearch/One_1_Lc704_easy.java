package LeetCode.Array.binarySearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName One_Lc704
 * @Description 二分查找（简单）
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * @Author 彭德民
 * @Date 2024/7/13 10:23
 */

public class One_1_Lc704_easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        System.out.println(search(nums, target));

    }

    //左闭右开的写法
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            //不要忘记left+
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
