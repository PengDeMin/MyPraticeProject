package LeetCode.LinkedList.Utils;

import sun.security.x509.InvalidityDateExtension;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：CreateList
 * @Date：2024/7/18 18:24
 * @Description：接收数组参数，创建列表，并打印输出
 * 具体处理：
 * Lc206_easy_reverseList：翻转链表
 * Lc234_easy_isPalindrome: 判断是否是回文串
 */

public class CreateList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valsArray = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        //linkedList.display(head);

        //ListNode newListHead = Lc206_easy_reverseList(head);//Lc206翻转链表

//        boolean isPalindrome  = Lc234_easy_isPalindrome(head);//Lc234判断是否是回文串
//        System.out.println(isPalindrome);

        //Lc_24_mid:两两交换链表中的节点
        ListNode newHead = Lc_24_mid_swapPairs(head);
        linkedList.display(newHead);

    }

    /*
    两两交换链表中的节点.重点是学会利用头结点
     */
    private static ListNode Lc_24_mid_swapPairs(ListNode head) {
        ListNode virtualHead = new ListNode(-1,head);
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

    /**
     * @Description Lc234判断是否是回文串
     * 时间：o（n）；
     * 空间：o（1）；
     * @Date 2024/7/19 16:26
     * @Param [head]
     * @Return boolean
     **/
    private static boolean Lc234_easy_isPalindrome(ListNode head) {
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
