import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        int left = j + 1, right = nums.length - 1;
        while (left < right) {
          int cur = nums[i] + nums[j] + nums[left] + nums[right];
          if (cur == target) {
            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            res.add(temp);
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1])
              left++;
            while (left < right && nums[right] == nums[right + 1])
              right--;
          } else if (cur < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return res;
  }
}
