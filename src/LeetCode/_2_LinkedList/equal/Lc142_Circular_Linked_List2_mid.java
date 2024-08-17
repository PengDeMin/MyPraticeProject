package LeetCode._2_LinkedList.equal;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName Lc142_Circular_Linked_List2_mid
 * @Author Demin Peng
 * @Date 2024/8/17 17:01
 * @Description 环形列表2
 */

public class Lc142_Circular_Linked_List2_mid {

    public static void main(String[] args) {
        int[] valsArrayA = new int[]{4,1,8,4,5};
        SingleLinkedList linkedListA = new SingleLinkedList(valsArrayA);
        ListNode resNode = detectCycle(linkedListA.head);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //根据数学公式推导，第一步先让两者相遇，不相遇说明没环
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //相遇后，让两个节点分别从起点和相遇点一起同速度走，最终会在入环处相遇
            if(slow == fast){
                ListNode tmp1 = head;
                while(tmp1 != slow){
                    tmp1 = tmp1.next;
                    slow = slow.next;
                }
                return tmp1;
            }
        }
        //能从大循环出来，说明没环
        return null;
    }
}
