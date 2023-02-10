package LinkedList;


/**
 * Example 2: 141. Linked List Cycle
 *
 * Given the head of a linked list, determine if the linked list has a cycle.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 */
public class FastSlowPtrE2 {

  public boolean findCircle(ListNode head) {
    var slow = head;
    var fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        return true;
      }
    }
    return false;
  }

}