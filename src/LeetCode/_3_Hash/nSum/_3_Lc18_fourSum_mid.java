package LeetCode._3_Hash.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Lc18
 * @Description 四数之和
 * @Author 彭德民
 * @Date 2024/5/3 22:44
 */

public class _3_Lc18_fourSum_mid {
    public static void main(String[] args) {
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //调用前一定要排序,因为这里不要求返回结果每个数字的下标
        //所以放心的排序，不用做备份
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    /**
     * @param nums：给定的源数组
     * @param n：要求解的元组规模
     * @param start：从给定源数组开始计算的索引位置
     * @param target：对于这个规模的元组们要求解的和
     * @return
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int numsLen = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        //至少是要求解二元组吧，也就是twoSum；而且比如你让我求三元组，不能给我的源数组长度只有2吧
        if (n < 2 || numsLen < n) {
            return res;
        }
        //如果求解的元组规模大于2（即nSum的n大于2），先递归往下化简，
        if (n != 2) {
            //确定n规模元组中第一个数
            //注意开始位置是start而不是0，因为前面的数在上个层级已经被确定了
            for (int i = start; i < numsLen; i++) {
                // 求解（n-1）Sum问题，也就是确定n-1规模的元组列表，n-1规模元组的和=n规模元组和-当前的第一个数字
                List<List<Integer>> subSum = nSumTarget(nums, n - 1, i + 1, (long) target - (long) nums[i]);

                //处理（n-1）Sum问题所得结果(拿到的是n-1规模的元组列表)
                for (List<Integer> arr : subSum) {
                    //让列表中的每个n-1规模元组都把第一个数添加进去，恢复成n规模元组
                    arr.add(nums[i]);
                    //再把这个恢复好的n规模元组结果加入到结果集中，也就是元组列表中
                    res.add(arr);
                }
                //为了不让n规模元组中第一个数重复（那样结果可能就重复了）
                //跳过后面与这个数相同的数字，当然如果没有相同的就不跳
                while (i < numsLen - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        //如果往下化简迭代，进入到最基础的twoSum问题，则求解2规模的元组列表
        else {
            //最基础的twoSum问题就是双指针那套操作
            //注意下面左指针开始位置是start而不是0，因为前面的数在上个层级已经被确定了
            int left = start, right = numsLen - 1;
            while (left < right) {
                Integer leftNum = nums[left];
                Integer rightNum = nums[right];
                Integer sum = leftNum + rightNum;
                //大了，右指针左移（并要求跳过重复当前大了的数）
                if (sum > target) {
                    while (left < right && nums[right] == rightNum) {
                        --right;
                    }
                }
                //小了，左指针右移（并要求跳过重复当前小了的数）
                else if (sum < target) {
                    while (left < right && nums[left] == leftNum) {
                        ++left;
                    }
                }
                //刚好相等耶，干净记录下来这两个数，并且为防止后面出现一样结果
                //要求直接跳过等于当前leftNum和rightNum的数字
                else {
                    res.add(new ArrayList<Integer>(Arrays.asList(leftNum, rightNum)));
                    while (left < right && nums[right] == rightNum) {
                        --right;
                    }
                    while (left < right && nums[left] == leftNum) {
                        ++left;
                    }
                }
            }
        }
        return res;
    }

}
