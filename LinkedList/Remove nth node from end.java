class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode d = new ListNode();
    d.next = head;
    ListNode slow = d;
    ListNode fast = d;
    while (fast != null && n > 0) {
      fast = fast.next;
      n--;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return d.next;
  }
}
