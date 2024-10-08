package LeetCode._2_LinkedList.swap;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @Author：彭德民
 * @ClassName：_1_Lc203_easy
 * @Date：2024/7/17 19:35
 * @Description：移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */

public class _0_Lc203_removeElements_easy {
    public static void main(String[] args) {
        int[] valsArray = new int[]{7,7,7,7};
        int val = 7;
        SingleLinkedList l = new SingleLinkedList(valsArray);
//        ListNode head = l.createListFromArray(valsArray);
//        ListNode newHead = removeElements(head, val);
        l.displayFromOwn();

        ListNode newHead = removeElements(l.head, val);
        l.display(newHead);
    }

    //虚拟头指针
    public static ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead = new ListNode(-1,head);
        ListNode cur = virtualHead;

        while (null != cur.next ) {
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur= cur.next;
            }
        }
        return virtualHead.next;
    }
}
