package LeetCode._3_Hash.nSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lc1
 * @Description 两数之和（简单）
 * @Author 彭德民
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 题目提示只有一个有效答案
 * @Date 2024/5/3 19:39
 */

public class _1_Lc1_twoSum_easy {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        int[] res = twoSum2(nums, target);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    //使用了哈希表的版本
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0 || nums == null) {
            return res;
        }
        //利用Map来记录符合要求的元素的下标，以及（下面有讲）
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //针对当前遍历的nums[i]，看差值是多少
            int need = target - nums[i];
            //看差值这个数在不在map中，其实就是巧妙地利用resMap.containsKey(need)
            //来代替原本暴力解法里的的第二个for循环，而且它的寻找速度更快
            if (resMap.containsKey(need)) {
                res[0] = i;
                res[1] = resMap.get(need);
                break;
            } else {
                //如果不在里面，就先把nums[i]放入map中
                //如果缘分到位，以后它会作为别的数的need出现
                resMap.put(nums[i], i);
            }
        }
        return res;
    }

    //使用了双指针的版本
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0 || nums == null) {
            return res;
        }
        //使用双指针的前提是数组要有序，因此先备份各个数字及其对应的下标
        int[] copyNums = nums.clone();
        int leftNum = 0, rightNum = 0;
        Arrays.sort(nums);

        //两个指针分别从两端往中间走
        //由于target必须要由两个数组成，所以left不能有等于right的时候，否则指向的时同一个数
        for (int left = 0, right = nums.length - 1; left < right; ) {
            int sum = nums[left] + nums[right];
            //若两数之和大于目标，说明右边的数大了，往小试试，因此右指针左移
            if (sum > target) {
                --right;
            }
            //若两数之和小于目标，说明左边的数小了，往大试试，因此左指针右移
            else if (sum < target) {
                ++left;
            }
            //相等那说明缘分到了，直接记录下这两个数退出循环
            else {
                leftNum = nums[left];
                rightNum = nums[right];
                break;
            }
        }

        //找到这两个数在原本数组中的位置
        int find = 0;
        //左边数找到了就不再进入第一个if语句了，
        //避免因leftNum=rightNum而重复进入第一个if语句
        boolean isLeftGet = false;
        for (int i = 0; i < copyNums.length; i++) {
            if (!isLeftGet && copyNums[i] == leftNum) {
                res[0] = i;
                find++;//找到下标+1
                isLeftGet = true;
                if (find == 2) {
                    //数找齐了，退出循环
                    break;
                } else {
                    //没找齐，直接进入下一轮循环去找第二个数的下标
                    //避免因leftNum=rightNum而进入下面的if语句
                    continue;
                }
            }
            if (copyNums[i] == rightNum) {
                res[1] = i;
                find++;//找到下标+1
                if (find == 2) {
                    //数找齐了，退出循环
                    break;
                }
            }
        }
        return res;
    }
}
