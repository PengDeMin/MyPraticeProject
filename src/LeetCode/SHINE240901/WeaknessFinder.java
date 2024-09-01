package LeetCode.SHINE240901;

import java.util.Arrays;

/**
 * @ClassName TI
 * @Author Demin Peng
 * @Date 2024/9/1 20:01
 * @Description
 * 我们将数x的弱点定义为小于x且除数比x多的正整数的数量，
 * 因此，数字越弱，它的整体弱点就越大。对于给定的整数n，
 * 需要回答两个问题:[1,n]范围内最弱数字的弱点是什么?
 * [1,n]范围内有多少数字有这个弱点?将答案作为两个元素的数组返回，
 * 其中第一个元素是第一个问题的答案，第二个元素是第二个问题的答案。
 *
 * 输入：9
 * 输出[2,2]
 */

public class WeaknessFinder {
    public static int[] findWeakestNumbers(int n) {
        // 初始化最大弱点为0，最大弱点出现的次数为0
        int maxWeakness = 0;
        int count = 0;

        // 遍历所有数字并计算它们的弱点
        for (int i = 1; i <= n; i++) {
            int weakness = calculateWeakness(i, n);
            if (weakness > maxWeakness) {
                // 如果找到更大的弱点，则更新最大弱点和计数
                maxWeakness = weakness;
                count = 1;
            } else if (weakness == maxWeakness) {
                // 如果弱点相同，增加计数
                count++;
            }
        }

        return new int[]{maxWeakness, count};
    }

    private static int calculateWeakness(int x, int n) {
        int divisorsCount = 0;
        for (int i = 1; i < x; i++) {
            if (i * (n / i) > x * (n / x)) {
                // 计算小于x的数i的除数数量是否比x多
                divisorsCount++;
            }
        }
        return divisorsCount;
    }

    public static void main(String[] args) {
        int n = 9; // 示例输入
        int[] result = findWeakestNumbers(n);
        System.out.println(Arrays.toString(result));
    }
}
