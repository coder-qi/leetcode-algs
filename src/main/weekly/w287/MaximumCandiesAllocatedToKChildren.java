package weekly.w287;

import java.util.Arrays;

import util.ArrayUtils;

import static util.ArrayUtils.array;

/**
 * 2226. 每个小孩最多能分到多少糖果：https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
 */
public class MaximumCandiesAllocatedToKChildren {

    public static int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int n = candies.length;
        int a = (int) (k / n) + 1, b = n - (int) (k % n) - 1;
        return candies[b] / a;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(array("[5,8,6]"), 3));
        System.out.println(maximumCandies(array("[2,5]"), 11));
    }

}
