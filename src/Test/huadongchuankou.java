package Test;

/**
 * @ClassName huadongchuankou
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/23 19:48
 */

public class huadongchuankou {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;//取一个实际永远给不到的初值,也是最终的结果
        int subLength = 0;//暂存值
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = 0;
            for(int j = i+1; j<nums.length; j++){
                sum += nums[j];
                if(sum>=target){
                    subLength = j-i+1;
                    res = res < subLength ? res : subLength;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
