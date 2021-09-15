import java.util.HashSet;

class Solution {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int e : nums) {
      set.add(e);
    }
    int maxlen = 0;
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i] - 1))
        continue;
      int len = 1;
      while (set.contains(nums[i] + len)) {
        len++;
      }
      maxlen = Math.max(maxlen, len);
    }
    return maxlen;
  }
}
