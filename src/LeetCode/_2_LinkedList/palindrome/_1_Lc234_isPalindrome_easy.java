package LeetCode._2_LinkedList.palindrome;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：_1_Lc234_isPalindrome_easy
 * @Date：2024/7/19 17:54
 * @Description：判断是否是回文串
 */

public class _1_Lc234_isPalindrome_easy {

    {
        Scanner scanner = new Scanner(System.in);
        int[] valsArray = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        boolean isPalindrome  = isPalindrome(head);//Lc234判断是否是回文串
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(ListNode head) {
        //1、一快一慢双指针走到尾，获取链表前半部分的最后一个节点
        ListNode firsttHalfEnd = getFirstHalfEnd(head);
        //2、翻转链表的后半部分，获取链表后半部分的第一个节点
        ListNode secondHalfStart = Lc206_easy_reverseList(firsttHalfEnd.next);

        //3、在一个链表上开始比较
        ListNode cur1 = head;
        ListNode cur2 = secondHalfStart;
        //比较持续过程以后半部分链表长度为准，可以覆盖前后不等以及后比前长一个节点的情况。
        while(cur2 != null){
            //一个不等直接返回false
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    //一快一慢双指针走到尾，获取链表前半部分的最后一个节点
    private static ListNode getFirstHalfEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //Lc206_easy:翻转链表
    private static ListNode Lc206_easy_reverseList(ListNode head) {

        ListNode cur = head;
        ListNode tmp;
        ListNode newListHead = null;

        while(cur!=null){
            tmp = cur.next;
            cur.next = newListHead;
            newListHead = cur;
            cur = tmp;
        }
        return newListHead;
    }

}
