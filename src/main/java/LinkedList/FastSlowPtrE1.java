package LinkedList;

/**
 * Example 1: Given the head of a linked list with an odd number of nodes head, return the value of the node in the middle.
 *
 * For example, given a linked list that represents 1 -> 2 -> 3 -> 4 -> 5, return 3.
 */
public class FastSlowPtrE1 {
  public int findMid(ListNode head) {
    var slow = head;
    var fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.val;
  }
  
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
}