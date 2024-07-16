package LeetCode.Array.SlidingWindow;

import java.util.*;

/**
 * @Author：彭德民
 * @ClassName：Three_2_Lc904_mid
 * @Date：2024/7/16 19:34
 * @Description：水果成篮（找至多包含两种元素的最长子串，返回其长度）
 *
 * 输入：fruits = [1,2,1]
 * 输出：3
 *
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 */

public class Three_2_Lc904_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fruits = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(totalFruit2(fruits));
    }


    //代码比较笨重的版本，33行
    private static int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int curlen = 0, maxlen = Integer.MIN_VALUE;
        int type = 0;
        Map<Integer,Integer> recordMap = new HashMap<>();

        while(right < fruits.length) {
            //记录当前元素，窗口右边滑动，扩大窗口
            if(!recordMap.containsKey(fruits[right])) {
                type++;
            }
            recordMap.put(fruits[right], recordMap.getOrDefault(fruits[right],0)+1);
            curlen++;
            right++;

            //如果种类超过两种达到3种，窗口左边滑动，收缩窗口，直至种类只有一种
            if(type>2){
                //先记录当前最大值
                maxlen = Math.max(maxlen,curlen-1);
                while(type>2){
                    recordMap.put(fruits[left], recordMap.get(fruits[left])-1);

                    if(recordMap.get(fruits[left])==0){
                        recordMap.remove(fruits[left]);
                        type--;
                    }

                    left++;
                    curlen--;
                }
            }
        }
        return maxlen == Integer.MIN_VALUE ? curlen : Math.max(curlen,maxlen);
    }


    //代码简洁版本，26行
    private static int totalFruit2(int[] fruits) {
        int left = 0, right = 0;
        int maxlen = Integer.MIN_VALUE;

        Map<Integer,Integer> recordMap = new HashMap<>();

        while(right < fruits.length) {
            //记录当前元素，窗口右边滑动，扩大窗口
            recordMap.put(fruits[right], recordMap.getOrDefault(fruits[right],0)+1);
            right++;

            //如果种类超过两种达到3种，窗口左边滑动，收缩窗口，直至种类只有两种
            while(recordMap.size()>2){
                recordMap.put(fruits[left], recordMap.get(fruits[left])-1);
                //如果当前移出窗口字符的次数已为0，则移出map
                if(recordMap.get(fruits[left])==0){
                    recordMap.remove(fruits[left]);
                }
                //窗口移动
                left++;
            }
            //记录此时种类为2时的窗口长度并更新最大窗口长度
            maxlen = Math.max(maxlen,right-left);
        }

        //长度不用特意设置变量来记录，只需用结束循环时的窗口左右边相减即可
        return maxlen;
    }
}
