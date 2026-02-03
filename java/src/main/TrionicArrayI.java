/**
 * 3637. 三段式数组 I：https://leetcode.cn/problems/trionic-array-i
 */
public class TrionicArrayI {

    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4 || nums[0] >= nums[1]) {
            return false;
        }
        boolean asc = true;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            if (nums[i] > nums[i - 1] != asc) {
                asc = !asc;
                cnt++;
            }
        }
        return cnt == 2;
    }

}
