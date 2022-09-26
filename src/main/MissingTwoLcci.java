import java.util.Arrays;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 面试题 17.19. 消失的两个数字：https://leetcode.cn/problems/missing-two-lcci/
 */
public class MissingTwoLcci {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingTwo(new int[] {1}))); // [2,3]
        System.out.println(Arrays.toString(missingTwo(new int[] {2,3}))); // [1,4]
        System.out.println(Arrays.toString(missingTwo(
            array(loadTestcase("missing-two-lcci-testcase-1.txt"))))); // [2050, 8184]
    }

    public static int[] missingTwo(int[] nums) {
        int m = nums.length, n = m + 2;
        int[] arr = new int[] {-1, -1};
        for (int i = 0; i < m; i++) {
            while (nums[i] != -1 && nums[i] != i + 1) {
                if (nums[i] > m) {
                    arr[nums[i] - m - 1] = nums[i];
                    nums[i] = -1;
                    break;
                } else {
                    int j = nums[i] - 1;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int p = i < m ? nums[i] : arr[i - m];
            if (p == -1) {
                ans[ans[0] == 0 ? 0 : 1] = i + 1;
            }
        }
        return ans;
    }
}
