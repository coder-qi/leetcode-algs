import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 719. 找出第 K 小的数对距离：https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */
public class FindKthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (k <= count(nums, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int count(int[] nums, int x) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = i;
            int target = nums[i] - x;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            result += i - left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(array("[1,3,1]"), 1)); // 0
        System.out.println(smallestDistancePair(array("[1,1,1]"), 2)); // 0
        System.out.println(smallestDistancePair(array("[1,6,1]"), 3)); // 5
    }

}
