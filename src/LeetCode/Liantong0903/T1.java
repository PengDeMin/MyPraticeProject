package LeetCode.Liantong0903;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T1
 * @Author Demin Peng
 * @Date 2024/9/3 21:32
 * @Description TODO
 */

public class T1 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        Arrays.sort(output);
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += number + ", ";
        }
        return length+ ",nums=["+ result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line != null){
            int[] nums = stringToIntegerArray(line);
            String out = removeDuplicates(nums);
            System.out.println(out);
        }
    }
    public static String removeDuplicates(int[] nums) {
        //请在此处完成相关代码
        Arrays.sort(nums);
        //清除nums数组中的重复数字
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[index] != nums[i]){
                nums[++index]=nums[i];
            }
        }
        int[] newNums = Arrays.copyOfRange(nums,0,index+1);
        return integerArrayToString(newNums,index+1);

    }
}

