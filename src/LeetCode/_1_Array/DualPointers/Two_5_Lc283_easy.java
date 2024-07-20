package LeetCode._1_Array.DualPointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：Two_5_Lc283_easy
 * @Date：2024/7/15 19:51
 * @Description：移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */

public class Two_5_Lc283_easy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    //双指针,自己做的版本，运行时间有点慢,33ms
    private static void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            //满指针找0
            while (slow < nums.length-1 && nums[slow] != 0 ) {
                slow++;
            }

            if(slow == nums.length-1){
                break;
            }

            fast = slow;
            //快指针找非0
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }

            if(fast == nums.length){
                break;
            }

            //交换
            nums[slow] += nums[fast];
            nums[fast] = nums[slow] - nums[fast];
            nums[slow] -= nums[fast];

            slow++;
        }
    }

    //题解精选双指针版本,1ms
    private static void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }

        //第一次遍历，把数组中所有非零的数字放到左边去
        int noZero = 0;
        for (int i = 0 ; i<nums.length;i++){
            if(nums[i]!=0){
                nums[noZero++] = nums[i];
            }
        }
        //遍历结束时，nozero代表非零元素个数，因此第二次遍历把nums[noZero]之后的元素全部置0即可，因为0不要符合顺序
        for(;noZero< nums.length;noZero++ ){
            nums[noZero]=0;
        }
    }

    /*
    双指针：一次遍历的快排思想版本，其实和上面我自己写的版本的思想本质一样，都是一次遍历
    但我自己的不够精炼，1ms
     */
    private static void moveZeroes3(int[] nums) {
        if(nums==null) {
            return;
        }

        int j = 0;
        //把不等于0的元素放到左边边，把等于0的元素放到右边
        for (int i = 0; i< nums.length;i++){
            if(nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
