/**
 * 300. 最长递增子序列：https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (nums[i] > d[mid]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18})); // 4
        System.out.println(lengthOfLIS(new int[] {0,1,0,3,2,3})); // 4
        System.out.println(lengthOfLIS(new int[] {7,7,7,7,7,7,7})); // 1
    }

}
