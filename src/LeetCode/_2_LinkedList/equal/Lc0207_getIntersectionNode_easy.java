package LeetCode._2_LinkedList.equal;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName Lc0207_getIntersectionNode_easy
 * @Author Demin Peng
 * @Date 2024/8/17 14:05
 * @Description 链表相交,此题在本地无法验证，因为不是用真正相同的节点造的链表，而只是用相同的值
 */

public class Lc0207_getIntersectionNode_easy {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] valsArray = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int[] valsArrayA = new int[]{4,1,8,4,5};
        int[] valsArrayB = new int[]{5,0,1,8,4,5};
        SingleLinkedList linkedListA = new SingleLinkedList(valsArrayA);
        SingleLinkedList linkedListB = new SingleLinkedList(valsArrayB);

        ListNode resNode = getIntersectionNode(linkedListA.head, linkedListB.head);
        linkedListA.displayFromOwn();
        linkedListB.displayFromOwn();
        System.out.println(resNode==null ? "null" : resNode.val);
    }

    /***
     * @Param [LeetCode._2_LinkedList.Utils.ListNode, LeetCode._2_LinkedList.Utils.ListNode]
     * @return LeetCode._2_LinkedList.Utils.ListNode
     * @Description 合并链表实现同步移动的方法
     **/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (null == p1) {
                p1 = headB;
            } else p1 = p1.next;

            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (null == p2) {
                p2 = headA;
            } else p2 = p2.next;
        }
        //最终要么是相遇而结束循环，要么是同时在不同链表上走到末尾而结束循环
        return p1;
    }

    /***
     * @Param [LeetCode._2_LinkedList.Utils.ListNode, LeetCode._2_LinkedList.Utils.ListNode]
     * @return LeetCode._2_LinkedList.Utils.ListNode
     * @Description 两次遍历，一次求差值，一次长先走后一起走
     **/
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int diff = 0;
        //1、第一次遍历，为了计算两条链表长度的差值
        while (null != p1 && null != p2){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //让长的走完，计算长度差值
        while (null != p1){
            p1 = p1.next;
            diff++;
        }
        while (null != p2){
            p2 = p2.next;
            diff--;
        }
        //没变化说明两者一样长且不相交
        if(diff == 0){
            return null;
        }

        //第二次遍历，让长的先走diff步，这样两者剩下的距离相同
        p1 = headA;
        p2 = headB;
        //差值为正数则A长，为负数则B长
        while(diff > 0){
            p1 = p1.next;
            diff--;
        }
        while(diff < 0){
            p2 = p2.next;
            diff++;
        }
        //一起走
        while (null != p1){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
