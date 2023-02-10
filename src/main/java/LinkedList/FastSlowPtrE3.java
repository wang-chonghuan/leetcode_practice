package LinkedList;

/**
 * Example 3: Given the head of a linked list and an integer k,
 * return the kth node from the end.
 *
 * For example, given the linked list that represents
 * 1 -> 2 -> 3 -> 4 -> 5 and k = 2,
 * return the node with value 4, as it is the 2nd node from the end.
 *
 * 思路,用两个同样速度的指针,但是f指针比s指针靠前了k个位置
 * 这样f指针到底时,s指针就指向了desired position
 *
 * 比如k=3
 * 那么起始时,k是在0,1,2,3中的2的位置
 */
public class FastSlowPtrE3 {
    public ListNode kFromEnd(ListNode head, int k) {
        var fast = head;
        var slow = head;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
