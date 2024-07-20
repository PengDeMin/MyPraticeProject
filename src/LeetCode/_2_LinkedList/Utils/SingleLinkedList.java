package LeetCode._2_LinkedList.Utils;


/**
 * @Author：彭德民
 * @ClassName：MySingleLinkedList
 * @Date：2024/7/18 17:54
 * @Description：单链表
 */

public class SingleLinkedList {
    int size;//链表中元素数量

    public ListNode head;

    public SingleLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    public SingleLinkedList(int[] valsArray) {
        size = 0;
        head = new ListNode(-1);
        if(valsArray == null || valsArray.length == 0){
            return;
        }

        head.val = valsArray[0];
        ListNode currentNode = head;

        for (int i = 1; i < valsArray.length; i++) {
            ListNode newNode = new ListNode(valsArray[i]);
            currentNode.next =newNode;
            currentNode = newNode;
            size++;
        }
    }

    //打印链表中的节点
    public void displayFromOwn(){
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    //创建链表并返回头结点
    public ListNode createListFromArray(int[] valsArray) {
        if(valsArray == null || valsArray.length == 0){
            return null;
        }

        head.val = valsArray[0];
        ListNode currentNode = head;

        for (int i = 1; i < valsArray.length; i++) {
            ListNode newNode = new ListNode(valsArray[i]);
            currentNode.next =newNode;
            currentNode = newNode;
            size++;
        }

        return head;
    }

    //打印链表中的节点
    public void display(ListNode head){
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

