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

// General solution for kSum

    public class Solution {
        int len = 0;
        public List<List<Integer>> fourSum(int[] nums, int target) {
            len = nums.length;
            Arrays.sort(nums);
            return kSum(nums, target, 4, 0);
        }
       private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            if(index >= len) {
                return res;
            }
            if(k == 2) {
            	int i = index, j = len - 1;
            	while(i < j) {
                    //find a pair
            	    if(target - nums[i] == nums[j]) {
            	    	List<Integer> temp = new ArrayList<>();
                    	temp.add(nums[i]);
                    	temp.add(target-nums[i]);
                        res.add(temp);
                        //skip duplication
                        while(i<j && nums[i]==nums[i+1]) i++;
                        while(i<j && nums[j-1]==nums[j]) j--;
                        i++;
                        j--;
                    //move left bound
            	    } else if (target - nums[i] > nums[j]) {
            	        i++;
                    //move right bound
            	    } else {
            	        j--;
            	    }
            	}
            } else{
                for (int i = index; i < len - k + 1; i++) {
                    //use current number to reduce ksum into k-1sum
                    ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                    if(temp != null){
                        //add previous results
                        for (List<Integer> t : temp) {
                            t.add(0, nums[i]);
                        }
                        res.addAll(temp);
                    }
                    while (i < len-1 && nums[i] == nums[i+1]) {
                        //skip duplicated numbers
                        i++;
                    }
                }
            }
            return res;
        }
    }
