package LeetCode.Hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Lc349
 * @Description 两个数组的交集(简单)
 * @Author 彭德民
 * 给定两个数组 nums1 和 nums2 ，返回它们的交集。
 * 输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序 。
 * @Date 2024/5/3 13:30
 */

public class Lc349 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2,1};
        int[] res = intersection2(nums1, nums2);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }

    //用了Hash数组的版本：优点耗时短内存占用少，缺点代码长
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        int[] freNum1 = new int[1002];
        int[] freNum2 = new int[1002];
        //nums1[index]记录的就是num1中关于index这个数字的频数
        for (int num : nums1) {
            ++freNum1[num];
        }
        for (int num : nums2) {
            ++freNum2[num];
        }
        for(int index = 0; index <freNum1.length;index++) {
            if (freNum1[index] > 0 && freNum2[index] > 0) {
                resList.add(index);
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    //用了HashSet的版本：优点代码简洁，缺点耗时长，耗内存多
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> resSet2 = new HashSet<>();
        //1、去重添加num1中所有数字
        for (int num : nums1) {
            resSet.add(num);
        }

        for (int num : nums2) {
            if (resSet.contains(num)) {
                resSet2.add(num);
            }
        }
        //先mapToInt(Integer::intValue)：把包装类型拆箱回基本类型
        //再toArray()：变成数组
        return resSet2.stream().mapToInt(Integer::intValue).toArray();
    }
}
