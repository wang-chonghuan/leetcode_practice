package LinkedList;

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