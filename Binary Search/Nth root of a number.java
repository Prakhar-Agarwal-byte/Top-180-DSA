// TC n*log(m*10^d)

public class Solution {
  public double findNthRoot(int n, int m, int d) {
    double low = 1;
    double high = m;
    double mid = 0;
    double eps = Math.pow(10, -6);
    while (high - low > eps) {
      mid = (low + high) / 2;
      if (multiply(mid, n) > m) {
        high = mid;
      } else {
        low = mid;
      }
    }
    return mid;
  }

  private double multiply(double mid, int n) {
    double ans = 0;
    for (int i = 0; i < n; i++) {
      ans *= mid;
    }
    return ans;
  }
}
