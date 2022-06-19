package weekly.w285;

/**
 * 2210. 统计数组中峰和谷的数量：https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/
 */
public class CountHillsAndValleysInAnArray {

    public static int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            while (j < n && nums[i] == nums[j]) {
                j++;
            }
            if (j < n) {
                if (nums[i] > nums[i - 1]) {
                    if (nums[i] > nums[j]) {
                        ans++;
                    }
                } else {
                    if (nums[i] < nums[j]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
