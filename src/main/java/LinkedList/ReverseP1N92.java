package LinkedList;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * 思路：获得两个节点，获得区间外侧的两个哨兵节点
 *  对两个节点之间的链表执行反转
 *  再把这个子链表链接进哨兵节点里
 */
public class ReverseP1N92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftSentry = dummy, rightSentry = null;
        ListNode leftNode = null, rightNode = null;
        int curPos = 1;
        ListNode preNode = dummy;
        ListNode curNode = head;
        while(curNode != null) {
            if(curPos == left) {
                leftSentry = preNode;
                leftNode = curNode;
            }
            if(curPos == right) {
                rightNode = curNode;
                break;
            }
            curPos++;
            preNode = curNode;
            curNode = curNode.next;
        }
        rightSentry = rightNode.next;
        if(rightNode == null) {
            return head;
        }
        ListNode prev = leftSentry;
        ListNode cur = leftNode;
        while(cur != rightSentry) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        leftSentry.next = rightNode;
        leftNode.next = rightSentry;
        return dummy.next;
    }
}
