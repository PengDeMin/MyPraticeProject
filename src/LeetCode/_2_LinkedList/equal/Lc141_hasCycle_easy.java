package LeetCode._2_LinkedList.equal;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName Lc141_hasCycle_easy
 * @Author Demin Peng
 * @Date 2024/8/17 15:20
 * @Description 判断链表中是否有环
 */

public class Lc141_hasCycle_easy {

    public static void main(String[] args) {
        int[] valsArrayA = new int[]{4,1,8,4,5};
        SingleLinkedList linkedListA = new SingleLinkedList(valsArrayA);
        System.out.println(hasCycle(linkedListA.head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode cur1 = new ListNode();
        ListNode cur2 = new ListNode();
        cur1.next = head;
        cur2.next = head;
        while(null != cur2 && null != cur2.next){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur2 == cur1){
                return true;
            }

        }
        return false;
    }
}
