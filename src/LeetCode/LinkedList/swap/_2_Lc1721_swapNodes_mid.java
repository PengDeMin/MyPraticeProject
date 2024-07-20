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
//        Scanner scanner = new Scanner(System.in);
//        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
//        int k = scanner.nextInt();
        int[] valsArray = new int[]{7,9};
        int k = 2;
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = swapNodes3(head,k);
        linkedList.display(newHead);
    }

    //笨蛋方法，纯靠模拟出来的，需要考虑多种特殊情况，很耗费时间,3ms
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode virtualHead = new ListNode(-1,head);

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
        if(firstLeft!=revKNode){
            firstLeft.next = revKNode;
        }

        //如果第k个和倒数第k个刚好挨在一起，即k.next = firstRight = revKNode ,那就不交换了
        if(kNode.next != revKNode){
            revKNode.next = firstRight;
            secondLeft.next = kNode;
        }

        //如果第k个和倒数第k个刚好挨在一起，k前倒数K后，则上面的if不走，导致倒数第k个没法连接到第k个节点去
        if(kNode.next == revKNode){
            revKNode.next = kNode;
        }

        if(kNode!=secondRight){
            kNode.next = secondRight;
        }
        //如果第k个和倒数第k个刚好挨在一起，倒数k前K后，那要将他们链接起来
        else{
            kNode.next = revKNode;
        }

        //覆盖交换第一个和倒数第一个的情况
        if(firstLeft.val == -1){
            head = firstLeft.next;
        }
        //覆盖第k个被换到链表第一位的情况
        if(virtualHead.next == kNode){
            head = virtualHead.next;
        }
        return head;
    }

    //笨蛋方法，纯靠模拟出来的，需要考虑多种特殊情况，2ms
    //此方法用同步移动思想对上一种方法进行优化，不用再可以计算链表长度以及重新从头遍历找倒数第K个，减少时间复杂度
    public static ListNode swapNodes2(ListNode head, int k) {
        ListNode virtualHead = new ListNode(-1,head);

        ListNode firstLeft = virtualHead , secondLeft = virtualHead,
                firstRight, secondRight, kNode, revKNode;

        //找第K个节点的前驱和后继
        for (int i = 1; i < k; i++) {
            firstLeft = firstLeft.next;
        }
        kNode = firstLeft.next;
        firstRight = kNode.next;

        //找倒数第K个节点的前驱和后继
        //用同步思想
        ListNode temp = kNode;
        while(temp.next != null) {
            temp = temp.next;
            secondLeft = secondLeft.next;
        }
        revKNode = secondLeft.next;
        secondRight = revKNode.next;

        //交换
        if(firstLeft!=revKNode){
            firstLeft.next = revKNode;
        }

        //如果第k个和倒数第k个刚好挨在一起，即k.next = firstRight = revKNode ,那就不交换了
        if(kNode.next != revKNode){
            revKNode.next = firstRight;
            secondLeft.next = kNode;
        }

        //如果第k个和倒数第k个刚好挨在一起，k前倒数K后，则上面的if不走，导致倒数第k个没法连接到第k个节点去
        if(kNode.next == revKNode){
            revKNode.next = kNode;
        }

        if(kNode!=secondRight){
            kNode.next = secondRight;
        }
        //如果第k个和倒数第k个刚好挨在一起，倒数k前K后，那要将他们链接起来
        else{
            kNode.next = revKNode;
        }

        //覆盖交换第一个和倒数第一个的情况
        if(firstLeft.val == -1){
            head = firstLeft.next;
        }
        //覆盖第k个被换到链表第一位的情况
        if(virtualHead.next == kNode){
            head = virtualHead.next;
        }
        return head;
    }

    //值交换，虽然有点耍赖，但是用到了同步思想,1ms
    public static ListNode swapNodes3(ListNode head, int k) {
        ListNode kNode = head;
        ListNode revKNode = head;

        //1、先定位到第k个节点
        for (int i = 1; i < k; i++) {
            kNode = kNode.next;
        }
        ListNode cur = kNode;

        //2、此时cur和还在链表表头的revKNode刚好相差k-1步，让后他两同时走
        //当cur走到链表尾部时，revKNode刚好走到倒数第K个节点的地方
        while (cur.next != null){
            cur = cur.next;
            revKNode = revKNode.next;
        }

        //耍赖进行值交换
        int temp = kNode.val;
        kNode.val = revKNode.val;
        revKNode.val = temp;
        return head;
    }
}
