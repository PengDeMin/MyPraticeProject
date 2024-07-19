package LeetCode.LinkedList.swap;

import LeetCode.LinkedList.Utils.ListNode;
import LeetCode.LinkedList.Utils.SingleLinkedList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：_2_Lc1721_swapNodes_mid
 * @Date：2024/7/19 18:06
 * @Description：给你链表的头节点 head 和一个整数 k 。
 *  交换链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 */

public class _2_Lc1721_swapNodes_mid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
        int k = scanner.nextInt();
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = swapNodes(head,k);
        linkedList.display(newHead);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode virtualHead = new ListNode(null,head);

        ListNode firstLeft = virtualHead , secondLeft = virtualHead,
                firstRight, secondRight, kNode, revKNode;

        //统计链表长度
        int listLength = 0;
        ListNode cur = head;
        while(cur != null){
            listLength ++;
            cur = cur.next;
        }

        //找第K个节点的前驱和后继
        for (int i = 1; i < k; i++) {
            firstLeft = firstLeft.next;
        }
        kNode = firstLeft.next;
        firstRight = kNode.next;

        //找倒数第K个节点的前驱和后继
        for (int i = 1; i < listLength-k+1; i++) {
            secondLeft = secondLeft.next;
        }
        revKNode = secondLeft.next;
        secondRight = revKNode.next;

        //交换
        firstLeft.next = kNode;
        kNode.next = firstRight;

        secondLeft.next = revKNode;
        revKNode.next = secondRight;

        return head;

    }
}
