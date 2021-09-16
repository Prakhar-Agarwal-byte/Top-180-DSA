class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    if (len == 0) return head;
    k = k % len;
    int n = len - k;
    cur = head;
    while (n-- > 1) {
      cur = cur.next;
    }
    ListNode head2 = cur.next;
    cur.next = null;
    head2 = reverse(head2);
    ListNode head1 = reverse(head);
    cur = head1;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = head2;
    return reverse(head1);
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode p = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
