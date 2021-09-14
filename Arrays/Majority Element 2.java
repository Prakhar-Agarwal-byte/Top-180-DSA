import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int nums1 = 1;
    int nums2 = 0;
    int count1 = 0;
    int count2 = 0;
    for (int ele : nums) {
      if (ele == nums1) {
        count1++;
      } else if (ele == nums2) {
        count2++;
      } else if (count1 == 0) {
        nums1 = ele;
        count1 = 1;
      } else if (count2 == 0) {
        nums2 = ele;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int ele : nums) {
      if (ele == nums1)
        count1++;
      if (ele == nums2)
        count2++;  
    }
    if (count1 > nums.length / 3)
      res.add(nums1);
    if (count2 > nums.length / 3)
      res.add(nums2);
    return res;
  }
}
