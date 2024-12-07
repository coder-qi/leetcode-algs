package weekly.w287;

import java.util.stream.IntStream;

import static util.ArrayUtils.array;

/**
 * 2226. 每个小孩最多能分到多少糖果：https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
 */
public class MaximumCandiesAllocatedToKChildren {

    public static int maximumCandies(int[] candies, long k) {
        int max = IntStream.of(candies).max().getAsInt();
        int left = 1, right = max + 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(mid, candies, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private static boolean check(int i, int[] candies, long k) {
        long result = 0;
        for (int c : candies) {
            result += c / i;
        }
        return result >= k;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(array("[5,8,6]"), 3)); // 5
        System.out.println(maximumCandies(array("[2,5]"), 11)); // 0
        System.out.println(maximumCandies(array("[1,2,6,8,6,7,3,5,2,5]"), 3)); // 6
    }

}
