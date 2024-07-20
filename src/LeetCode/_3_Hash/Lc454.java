package LeetCode._3_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lc454
 * @Description 四数之和II(中等)
 * @Author 彭德民
 * @Date 2024/5/4 15:46
 */

public class Lc454 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{0};
//        int[] nums3 = new int[]{0};
//        int[] nums4 = new int[]{0};
        System.out.println(fourSumCount2(nums1, nums2, nums3, nums4));
    }

    //使用哈希表的一道经典题目
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        //把a+b=leftNum看成一个整体，c+d=rightNum看成一个整体，
        // 四数之和即可变成两数之和

        //1、先看leftNum有多少取值情况（出现重复值的，每个值都要算一种情况，
        //比如5=2+3,5=4+1，代表两种不同的a+b组合成同样一个leftNum）
        //map里的key代表leftNum有多少种取值，value代表这种取值出现的次数，也就是a+b的组合次数
        Map<Integer, Integer> leftNumMap = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                leftNumMap.put(i + j, leftNumMap.getOrDefault(i + j, 0) + 1);
            }
        }
        //2、在看rightNum的取值情况
        Map<Integer, Integer> rightNumMap = new HashMap<>();
        for (int i : nums3) {
            for (int j : nums4) {
                rightNumMap.put(i + j, rightNumMap.getOrDefault(i + j, 0) + 1);

            }
        }

        //3、遍历比较两个map
        for (Map.Entry<Integer, Integer> leftEntry : leftNumMap.entrySet()) {
            //看是否有rightNum加上遍历到的这个leftNum等于0
            //如果有则rightNumMap.getOrDefault(0-leftEntry.getKey(),0)能取到相应的rightNum出现次数，至少为1次，否则就是0
            //leftNum和rightNum的出现次数各自代表了a+b和c+d的组合次数；a+b+c+d的总组合次数等于a+b和c+d的组合次数的笛卡尔积
            res = res + (leftEntry.getValue() * rightNumMap.getOrDefault(0 - leftEntry.getKey(), 0));
        }
        return res;
    }

    //针对上个方法的代码简化版本，减少耗时,只用一个map
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        //把a+b=leftNum看成一个整体，c+d=rightNum看成一个整体，四数之和即可变成两数之和
        //1、先看leftNum（a+b)有多少取值情况
        Map<Integer, Integer> leftNumMap = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                leftNumMap.put(i + j, leftNumMap.getOrDefault(i + j, 0) + 1);
            }
        }
        //2、以leftNum为基础去看rightNum（c+d）
        for (int i : nums3) {
            for (int j : nums4) {
                res += leftNumMap.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
