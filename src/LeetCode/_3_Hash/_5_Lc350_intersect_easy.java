package LeetCode._3_Hash;

import java.util.*;

/**
 * @ClassName Lc350
 * @Description 两个数组的交集II(简单)
 * @Author 彭德民
 * 给你两个整数数组 nums1 和 nums2 ，
 * 请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * @Date 2024/5/3 14:40
 */

public class _5_Lc350_intersect_easy {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 2, 1};
        int[] nums2 = new int[]{2, 2, 2, 3};
        int[] res = intersect2(nums1, nums2);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    //自己做的
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freRec1 = new HashMap<>();
        Map<Integer, Integer> freRec2 = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        //分别统计两个数组中的字符及其频数
        for (int num : nums1) {
            freRec1.put(num, freRec1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            freRec2.put(num, freRec2.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freRec1.entrySet()) {
            //访问双方都有的字符
            if (freRec2.containsKey(entry.getKey())) {
                //取得更少的频数
                int minFre = Math.min(entry.getValue(),
                        freRec2.get(entry.getKey()));
                //按频数添加
                for (int i = 0; i < minFre; i++) {
                    resList.add(entry.getKey());
                }
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }


    //优化版本的哈希表，只用了一个HashMap减少内促占用
    public static int[] intersect2(int[] nums1, int[] nums2) {
        //此版本限定nums1长度小于nums2，如果实际是大于则反转一下
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        //统计短数组的字符及频数
        Map<Integer, Integer> freRec1 = new HashMap<>();
        for (int num : nums1) {
            freRec1.put(num, freRec1.getOrDefault(num, 0) + 1);
        }

        //交集数组的初始长度以短数组为基准，因为交集数组的最大长度也就是短数组的长度
        int[] result = new int[nums1.length];
        int validIndex = 0;
        //遍历长数组
        for (int num : nums2) {
            //如果短数组里也有长数组的这个数字
            if (freRec1.getOrDefault(num, 0) > 0) {
                //将它放入结果集,同时结果集有效索引后移一位
                result[validIndex++] = num;
                //并更新减少一次此字符的次数，当减到0时，无论是那边还有这个字符，都已经匹配不上了
                freRec1.put(num, freRec1.get(num) - 1);
            }
        }
        //虽然返回数组的初始长度为短数组的长度，但经过交集处理返回的长度可能
        //变短，要以validIndex为准
        return Arrays.copyOfRange(result, 0, validIndex);
    }

    /**
     * 没用哈希表，而是用排序+双指针的方法
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        //1、先排序成从小到大
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        //分别初始化nums1、nums2和结果集的遍历索引
        int index1 = 0, index2 = 0, resIndex = 0;
        //当有一个数组走到头（也就是那个短数组），则遍历结束，因为交集
        //的最长长度也就是短数组的长度
        while (index1 < len1 && index2 < len2) {
            //如果两者字符相同，放入结果集，同时索引都往后移动一位
            if (nums1[index1] == nums2[index2]) {
                res[resIndex++] = nums1[index1];
                index1++;
                index2++;
            }
            //否则数字小的一方索引右移一位，也就抛弃掉这个小数字
            //因为这个小数字要么在上轮已经被作为重复数字被添加过，要么就不是重复数字
            else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(res, 0, resIndex);
    }
}
