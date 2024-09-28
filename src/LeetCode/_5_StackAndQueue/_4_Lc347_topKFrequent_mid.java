package LeetCode._5_StackAndQueue;


import java.sql.PreparedStatement;
import java.util.*;

/**
 * @Author：彭德民
 * @ClassName：_4_Lc347_topKFrequent_mid
 * @Date：2024/9/5 11:22
 * @Description：删除前K个高频元素
 * 核心解法是用优先级队列PriorityQueue（本质是一个大/小顶堆）实现
 * 利用优先级队列来对部分元素的频率进行排序，时间复杂度可以达到O(nlogk)，小于O(nlogn)
 * 而如果用快排，需要对整个数组进行排序，时间复杂度会达到O(nlogn)
 */

public class _4_Lc347_topKFrequent_mid {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());
        int[] res = topKFrequent(array, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        //1、统计每个数字出现的频率
        Map<Integer,Integer> freMap = new HashMap<>();
        for(int num: nums){
            freMap.put(num,freMap.getOrDefault(num,0)+1);
        }
        //2、遍历map获取频率放入小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> x : freMap.entrySet()){
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();
            //先进堆
            //如果堆元素超过K个，就弹出堆顶元素，堆顶元素就是最小的
            //最后堆里剩下的元素就是前K个高频元素
            pq.offer(tmp);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i = 0; i<k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
