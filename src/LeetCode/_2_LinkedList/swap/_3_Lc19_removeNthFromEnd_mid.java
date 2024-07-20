package LeetCode._2_LinkedList.swap;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName _3_Lc19_removeNthFromEnd_mid
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * @Author 彭德民
 * @Date 2024/7/20 14:34
 */

public class _3_Lc19_removeNthFromEnd_mid {
    public static void main(String[] args) {
        int[] valsArray = new int[]{7,9,4,5,6,7,8};
        int n = 7;
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = removeNthFromEnd(head,n);
        linkedList.display(newHead);
    }

    /**
     * 运用同步思想
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead = new ListNode(-1, head);
        ListNode fast = virtualHead;
        ListNode delPrev = virtualHead;
        //先让fast走n步
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        //两个一起走，当fast走到队尾，delPreV就走到要删除结点的前面
        while (fast.next != null) {
            fast = fast.next;
            delPrev = delPrev.next;
        }
        delPrev.next = delPrev.next.next;
        return virtualHead.next;
    }


    /***
     * @Param [LeetCode.LinkedList.Utils.ListNode, int]
     * @return LeetCode.LinkedList.Utils.ListNode
     * @Description 运用栈先进后出的思想
     **/
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur =  dummy;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n ; i++) {
            stack.pop();
        }

        //此时栈顶节点就是要删除结点的前驱
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}
