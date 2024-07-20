package LeetCode._2_LinkedList.swap;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName _4_Lc2095_deleteMiddle_mid
 * @Author NewUser
 * @Date 2024/7/20 16:25
 * @Description 删除链表
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 */

public class _4_Lc2095_deleteMiddle_mid {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
//        int k = scanner.nextInt();
        int[] valsArray = new int[]{7,9,8};

        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = deleteMiddle(head);
        linkedList.display(newHead);
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 指向被删的前继节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
