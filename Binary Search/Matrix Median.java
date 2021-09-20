import java.util.ArrayList;

public class Solution {
  public int findMedian(ArrayList<ArrayList<Integer>> A) {
    int low = 1;
    int high = Integer.MAX_VALUE;
    int n = A.size();
    int m = A.get(0).size();
    while (low <= high) {
      int mid = (low + high) / 2;
      int count = 0;
      for (int i = 0; i < n; i++) {
        count += countSmallerThanEqualToMid(A.get(i), mid);
      }
      if (count <= (n * m) / 2) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private int countSmallerThanEqualToMid(ArrayList<Integer> list, int n) {
    int low = 0;
    int high = list.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (list.get(mid) <= n) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}
