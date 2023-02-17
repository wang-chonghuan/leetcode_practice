package LinkedList;

import java.util.List;

/**
 * 24. Swap Nodes in Pairs
 * Given the head of a linked list,
 * swap every pair of nodes.
 * For example, given a linked list
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6,
 * return a linked list 2 -> 1 -> 4 -> 3 -> 6 -> 5.
 *
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * 思路,一个链表有很多对,奇数链表最后多一个,不用管
 * 第一个元素的next指针指向右侧
 * 左侧的next指针指向第二个元素
 * 第二个元素的next指针指向第一个元素
 * left-a-b-right
 * left-b-a-right
 *
 * [1,2,3,4]
 */
public class ReverseE1N24 {

    private ListNode swapOnePair(ListNode left) {
        // left后面至少有2个非空节点,交换它们的位置
        ListNode first = left.next;
        ListNode second = first.next;
        ListNode right = second.next;
        left.next = second;
        second.next = first;
        first.next = right;
        left.next = second; // 忘了这个了!!!
        return left.next.next;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        var cur = dummy;
        while(cur != null) {
            if(cur.next == null) {
                break;
            }
            if(cur.next.next == null) {
                break;
            }
            cur = swapOnePair(cur);
        }
        return dummy.next;
    }
}
