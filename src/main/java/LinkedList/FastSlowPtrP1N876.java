package LinkedList;

/**
 * 876. Middle of the Linked List
 *
 * Given the head of a singly linked list,
 * return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * 如果是偶数个, fast总是会停在倒数第二个位置
 * 1,2,3,4
 * 1,2
 * 如果是奇数个
 * 1,2,3
 * 1
 */
public class FastSlowPtrP1N876 {
    public ListNode findMid(ListNode head) {
        if(head == null) {
            return null;
        }
        var fast = head;
        var slow = head;
        while(fast.next != null || fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next != null && fast.next.next == null) {
            slow = slow.next;
        }
        return slow;
    }

    // 标准答案里fast一定能到最后一个位置,这就保证了slow能到偶数的第二个中间数!
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
