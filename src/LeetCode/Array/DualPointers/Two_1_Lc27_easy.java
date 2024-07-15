package LeetCode.Array.DualPointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Two_1_Lc27_easy
 * @Description 移除元素
 * 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k
 * @Author 彭德民
 * @Date 2024/7/13 16:03
 */

public class Two_1_Lc27_easy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int val = sc.nextInt();
        System.out.println(removeElement2(nums,val));
        for (int num : nums) {
            System.out.print(num+",");
        }
    }

    //双指针，前后双向指针,以右边指针作为主角来控制
    private static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        //这种方式本质是右指针作为主要角色去走，只有当左指针指向元素不为val时才往后走
        //同时左指针也起到了计数的作用
        while(left<=right){
            if(nums[left]==val){
                nums[left] = nums[right--];
            }else {
                left++;
            }
        }
        return left;
    }

    //双指针，快慢双指针，以走得快相对靠右边的指针来控制
    private static int removeElement2(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast<nums.length; fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }

        return slow;
    }
}
