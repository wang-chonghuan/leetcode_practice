package LinkedList;

/**
 * 反转一个单链表
 * 1-2-3-4
 * 4-3-2-1
 * 思路就是把每个元素的next指针指向它的前一个元素就行了
 */
public class ReverseE0 {
    ListNode reverseList(ListNode head) {
        var cur = head;
        ListNode left = null;
        while(cur != null) {
            if(cur != null) {
                var right = cur.next;
                cur.next = left;
                left = cur;
                cur = right;
            }
        }
        return left;
    }
}
