package LinkedList;

/**
 * 2130. Maximum Twin Sum of a Linked List asks for the maximum pair sum. The pairs are the first and last node, second and second last node, third and third last node, etc.
 *
 * 思路：提示要用到反转链表的技术
 * 用快慢指针，快指针一次走两格，慢指针一次走一格
 * 由于是偶数个节点，所以快指针走到底时，慢指针刚好走了一半
 * 此时慢指针继续走，但是走的同时，把链表反转，也就是后半段的链表是反转的
 * 当慢指针走到底时，链表也反转完了，此时再来一个指针
 * 新指针遍历前半段，慢指针遍历后半段，但是是逆序
 * 就求出twin和了
 */
public class ReverseE2N2130 {
    public int pairSum(ListNode head) {
        if(head == null) {
            return 0;
        }
        if(head.next.next == null) {
            return head.val + head.next.val;
        }
        var dummy = new ListNode(-1);
        dummy.next = head;
        var slow = dummy;
        var fast = dummy;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 现在slow在前段的最后，fast在后段的最后
        // 接下来慢指针继续遍历后半段，为了反转后半段
        // 这个地方出了两个BUG，如果while slow.next != null那么slow不会连接到反转链表上！另外此处要从slow开始遍历，而不是从slow.next开始，说明链表问题的开始和末尾以及连接处特别容易出错！
        ListNode prev = null;
        while(slow != null) {
            var next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 现在prev在后段的最后，而且后段已经反转
        // 现在用两个指针从两端往中间遍历，计算和
        var front = head;
        var back = prev;
        int curMax = Integer.MIN_VALUE;
        // 因为两个前后两段链表断了，所以要用这种方法判断是否到底
        while(front != null && back != null) {
            int sum = front.val + back.val;
            curMax = Math.max(curMax, sum);
            front = front.next;
            back = back.next;
        }
        return curMax;
    }
}
