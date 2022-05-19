import static util.ArrayUtils.array;

/**
 * 462. 最少移动次数使数组元素相等 II：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {

    public static int minMoves2(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long avg = sum / nums.length;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(avg - nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(array("[1,2,3]")));
        System.out.println(minMoves2(array("[1,10,2,9]")));
    }

}
