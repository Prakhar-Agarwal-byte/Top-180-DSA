class Solution {
  public void sortColors(int[] nums) {
    int low = 0, high = nums.length - 1, mid = 0;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0:
          swap(low++, mid++, nums);
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(mid, high--, nums);
          break;
      }
    }

  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
