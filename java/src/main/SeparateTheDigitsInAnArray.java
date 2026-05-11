import java.util.ArrayList;
import java.util.List;

/**
 * 2553. 分割数组中数字的数位：https://leetcode.cn/problems/separate-the-digits-in-an-array
 */
public class SeparateTheDigitsInAnArray {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length - i - 1] = list.get(i);
        }
        return ans;
    }
}
