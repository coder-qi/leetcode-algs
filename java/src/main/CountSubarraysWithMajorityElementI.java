/**
 * 3737. 统计主要元素子数组数目 I：https://leetcode.cn/problems/count-subarrays-with-majority-element-i/
 */
public class CountSubarraysWithMajorityElementI {

    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }
                if (count * 2 > j - i + 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
