/**
 * 3101. 交替子数组计数：https://leetcode.cn/problems/count-alternating-subarrays
 */
public class CountAlternatingSubarrays {

    public static long countAlternatingSubarrays(int[] nums) {
        int N = nums.length;
        long ans = 1;
        long prev = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i - 1]) {
                prev = 1;
                ans++;
            } else {
                prev++;
                ans += prev;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAlternatingSubarrays(new int[] {0, 1, 1}));
    }

}
