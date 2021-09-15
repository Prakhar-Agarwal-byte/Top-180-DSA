import java.util.HashMap;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int maxLen = 0;
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(j, map.get(s.charAt(i)) + 1);
      }
      maxLen = Math.max(maxLen, i - j + 1);
      map.put(s.charAt(i), i);
    }
    return maxLen;
  }
}
