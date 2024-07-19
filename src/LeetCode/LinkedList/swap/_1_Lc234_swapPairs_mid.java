package LeetCode.LinkedList.swap;

import LeetCode.LinkedList.Utils.ListNode;
import LeetCode.LinkedList.Utils.SingleLinkedList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：_1_Lc234_mid
 * @Date：2024/7/19 17:47
 * @Description：Lc234 两两交换链表中的节点
 */

public class _1_Lc234_swapPairs_mid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = swapPairs(head);
        linkedList.display(newHead);
    }

    /*
    两两交换链表中的节点.重点是学会新增一个虚拟头结点
     */
    private static ListNode swapPairs(ListNode head) {
        ListNode virtualHead = new ListNode<>(null,head);
        ListNode cur = virtualHead;

        while(cur.next != null && cur.next.next != null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next;

            cur.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            cur = tmp1;
        }
        return virtualHead.next;
    }
}
