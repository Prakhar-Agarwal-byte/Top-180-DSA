public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    boolean cycleExists = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycleExists = true;
        break;
      }
    }
    if (cycleExists) {
      fast = head;
      if (slow != fast) {
        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow.next;
      } else {
        while (fast.next != slow) {
          fast = fast.next;
        }
        return fast.next;
      }
    }
    return null;
  }
}
