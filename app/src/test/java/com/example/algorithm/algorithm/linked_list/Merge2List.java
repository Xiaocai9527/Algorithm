package com.example.algorithm.algorithm.linked_list;

/**
 * 合并两个升序链表
 * 思路: 虚拟头节点
 * 1.定义一个新的链表节点，用于保存合并后的链表。
 * 2.比较两个链表的当前节点，选择较小的节点添加到新链表中，并移动对应链表的指针。
 * 3.重复步骤2，直到两个链表中的一个被完全遍历。
 * 4.将另一个链表剩余的节点添加到新链表的末尾。
 * 5.返回新链表的头节点。
 * </>
 * 时间复杂度 O(m+n) 空间复杂度 O(1)
 */
public class Merge2List {


    public static void main(String[] args) {
        // listNode1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // listNode2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        Merge2List merge2List = new Merge2List();
        ListNode listNode = merge2List.merge2List(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + "-> ");
            listNode = listNode.next;
        }
    }


    private ListNode merge2List(ListNode l1, ListNode l2) {
        //1.create dummy listNode
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // add l1 node to dummy
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

}
