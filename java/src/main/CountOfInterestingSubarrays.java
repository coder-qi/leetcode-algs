import java.util.Arrays;
import java.util.List;

/**
 * 2845. 统计趣味子数组的数目：https://leetcode.cn/problems/count-of-interesting-subarrays
 */
public class CountOfInterestingSubarrays {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] cnt = new int[Math.min(nums.size() + 1, modulo)];
        int s = 0;
        long ans = 0;
        cnt[0] = 1;
        for (int num : nums) {
            if (num % modulo == k) {
                s++;
            }
            if (s >= k) {
                ans += cnt[(s - k) % modulo];
            }
            cnt[s % modulo]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountOfInterestingSubarrays app = new CountOfInterestingSubarrays();
        System.out.println(app.countInterestingSubarrays(Arrays.asList(3,2,4), 2, 1)); // 3
        System.out.println(app.countInterestingSubarrays(Arrays.asList(3,1,9,6), 3, 0)); // 2
        System.out.println(app.countInterestingSubarrays(Arrays.asList(11,12,21,31), 10, 1)); // 5
        System.out.println(app.countInterestingSubarrays(Arrays.asList(2,4), 7, 2)); // 0
        System.out.println(app.countInterestingSubarrays(Arrays.asList(2,2,5), 3, 2)); // 2
    }

}
