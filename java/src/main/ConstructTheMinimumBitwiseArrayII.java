import java.util.List;

/**
 * 3315. 构造最小位运算数组 II：https://leetcode.cn/problems/construct-the-minimum-bitwise-array-ii
 */
public class ConstructTheMinimumBitwiseArrayII {

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                int t = ~x;
                int lowbit = t & -t;
                ans[i] = x ^ (lowbit >> 1);
            }
        }
        return ans;
    }

}
