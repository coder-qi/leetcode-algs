import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 667. 优美的排列 II：https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
public class BeautifulArrangementII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5, 1)));
        System.out.println(Arrays.toString(constructArray(5, 2)));
        System.out.println(Arrays.toString(constructArray(5, 4)));
        System.out.println(Arrays.toString(constructArray(5, 3)));
    }

    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        Set<Integer> nums = new LinkedHashSet<>();
        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }
        ans[0] = 1;
        int index = 1;
        while (k != 1) {
            if (index % 2 == 0) {
                ans[index] = Math.abs(ans[index - 1] - k);
            } else {
                ans[index] = Math.abs(ans[index - 1] + k);
            }
            nums.remove(ans[index]);
            k--;
            index++;
        }
        for (int num : nums) {
            ans[index++] = num;
        }
        // 1 2 3 4 5
        // 1 = 1 2 3 4 5
        // 2 = 1 3 2 4 5
        // 3 = 1 4 2 3 5
        // 4 = 1 5 2 4 3
        return ans;
    }

}
