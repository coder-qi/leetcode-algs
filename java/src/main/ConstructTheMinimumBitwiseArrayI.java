import java.util.List;

/**
 * 3314. 构造最小位运算数组 I：https://leetcode.cn/problems/construct-the-minimum-bitwise-array-i
 */
public class ConstructTheMinimumBitwiseArrayI {

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int a = nums.get(i);
            int b = -1;
            for (int x = 1; x <= a; x++) {
                if ((x | (x + 1)) == a) {
                    b = x;
                    break;
                }
            }
            ans[i] = b;
        }
        return ans;
    }

}
