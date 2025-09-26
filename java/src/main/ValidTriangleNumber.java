import java.util.Arrays;

/**
 * 611. 有效三角形的个数：https://leetcode.cn/problems/valid-triangle-number
 */
public class ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int max = nums[i] + nums[j];
                int min = nums[j] - nums[i];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > min) {
                        if (nums[k] < max) {
                            res++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

}
