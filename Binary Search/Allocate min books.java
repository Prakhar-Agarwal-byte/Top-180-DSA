import java.util.ArrayList;

public class Solution {
  public int books(ArrayList<Integer> A, int B) {
    if (A.size() < B)
      return -1;
    int low = 0;
    int high = 0;
    int res = 0;
    for (int i = 0; i < A.size(); i++) {
      low = Math.max(low, A.get(i));
      high += A.get(i);
    }
    while (low <= high) {
      int mid = (low + high) / 2;
      if (numOfStudents(A, mid) <= B) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }

  private int numOfStudents(ArrayList<Integer> A, int mid) {
    int num = 1;
    int sum = 0;
    for (int i = 0; i < A.size(); i++) {
      if (sum + A.get(i) <= mid) {
        sum += A.get(i);
      } else {
        sum = A.get(i);
        num++;
      }
    }
    return num;
  }
}
