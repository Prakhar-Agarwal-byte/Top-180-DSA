class Solution {
  public int[] findDuplicateAndMissing(int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }
    for (int i = 1; i <= nums.length; i++) {
      xor = xor ^ i;
    }
    int setBitPos = xor & -xor;
    int x = 0, y = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & setBitPos) != 0) {
        x = x ^ nums[i];
      } else {
        y = y ^ nums[i];
      }
    }
    for (int i = 1; i <= nums.length; i++) {
      if ((i & setBitPos) != 0) {
        x = x ^ i;
      } else {
        y = y ^ i;
      }
    }
    // x is missing
    // y is repeated
    // we can cross check it by again looping through the array
    int[] arr = { x, y };
    return arr;
  }
}
