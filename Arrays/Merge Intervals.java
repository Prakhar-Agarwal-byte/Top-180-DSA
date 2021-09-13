import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    if (intervals.length == 0 || intervals == null) {
      return list.toArray(new int[0][]);
    }
    Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
    int[] inter = intervals[0];
    for (int[] cur : intervals) {
      if (cur[0] <= inter[1]) {
        inter[1] = Math.max(cur[1], inter[1]);
      } else {
        list.add(inter);
        inter = cur;
      }
    }
    list.add(inter);
    return list.toArray(new int[0][]);
  }
}
