import java.util.Arrays;

class Solution {
  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int start, int end) {
    int count = 0;
    while (start < end) {
      int mid = start + (end - start) / 2;
      count += mergeSort(nums, start, mid);
      count += mergeSort(nums, mid + 1, end);
      count += merge(nums, start, mid, end);
    }
    return count;
  }

  private int merge(int[] nums, int start, int mid, int end) {
    int count = 0, j = 0, k = start;
    int[] leftArr = Arrays.copyOfRange(nums, 0, mid + 1);
    int[] rightArr = Arrays.copyOfRange(nums, mid + 1, end + 1);
    for (int i = 0; i < leftArr.length; i++) {
      while (j < rightArr.length && leftArr[i] <= 2 * rightArr[j])
        j++;
      count += j;
    }
    int i = 0;
    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        nums[k++] = leftArr[i++];
      } else {
        nums[k++] = rightArr[j++];
      }
    }
    while (i < leftArr.length) {
      nums[k++] = leftArr[i++];
    }
    while (j < rightArr.length) {
      nums[k++] = rightArr[j++];
    }
    return count;
  }
}
