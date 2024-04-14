package com.example.algorithm.algorithm.linked_list;

/**
 * 反转链表
 */
public class ReverseLinkedList {


    public static void main(String[] args) {
        // 创建一个包含5个节点的链表，节点值分别为1, 2, 3, 4, 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode listNode = solution.reverseList(head);
        // 输出 5 4 3 2 1
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



}
