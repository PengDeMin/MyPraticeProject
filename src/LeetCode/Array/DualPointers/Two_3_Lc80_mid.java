package LeetCode.Array.DualPointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Two_3_Lc80_mid
 * @Description 删除有序数组中的重复项 II(元素最多重复2次)
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，
 * 返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author 彭德民
 * @Date 2024/7/13 17:24
 */

public class Two_3_Lc80_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(removeDuplicates(nums, 2));
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    /**
     * @param nums
     * @param keepTimes :允许重复元素出现的次数
     * @return
     */
    private static int removeDuplicates(int[] nums, int keepTimes) {
        int slow = 0;
        //直接使用foreach循环
        for (int number : nums) {
            //slow < keepTimes表示数组前面的元素最多可重复keepTimes次
            //nums[slow-keepTimes] != number表示数组中间元素判断是否重复了keepTimes次
            if (slow < keepTimes || nums[slow - keepTimes] != number) {
                nums[slow++] = number;
            }
        }
        return slow;
    }
}
