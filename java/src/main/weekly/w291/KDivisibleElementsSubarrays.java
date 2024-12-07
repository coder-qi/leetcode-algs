package weekly.w291;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static util.ArrayUtils.array;

/**
 * 6049. 含最多 K 个可整除元素的子数组：https://leetcode-cn.com/problems/k-divisible-elements-subarrays/
 */
public class KDivisibleElementsSubarrays {

    public static int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        Set<SubArray> subArrays = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    if (++cnt > k) {
                        break;
                    }
                }
                if (subArrays.add(new SubArray(nums, i, j + 1))) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static class SubArray {
        int from, to;
        int[] nums;
        int hash = 0;

        public SubArray(int[] nums, int from, int to) {
            this.nums = nums;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SubArray subArray = (SubArray) o;
            return Arrays.equals(nums, this.from, this.to,
                subArray.nums, subArray.from, subArray.to);
        }

        @Override
        public int hashCode() {
            int h = hash;
            if (h == 0) {
                h = 1;
                for (int i = from; i < to; i++) {
                    h = 31 * h + nums[i];
                }
                hash = h;
            }
            return h;
        }

    }

    public static void main(String[] args) {
        System.out.println(countDistinct(array("[2,3,3,2,2]"), 2, 2)); // 11
        System.out.println(countDistinct(array("[1,2,3,4]"), 4, 1)); // 10
    }

}
