package LeetCode.Liantong0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * @ClassName T3
 * @Author Demin Peng
 * @Date 2024/9/3 21:46
 * @Description TODO
 */

public class T3 {
    public static int maximumGap(int[] nums) {
        //在此处完成相关代码
        if(nums == null || nums.length<2){
            return 0;
        }
        //Arrays.sort(nums);
        //找出数组相邻元素之间差值的最大值
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]-nums[i-1]);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = maximumGap(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
}
