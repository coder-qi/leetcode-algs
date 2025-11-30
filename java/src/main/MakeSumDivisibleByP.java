import util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 1590. 使数组和能被 P 整除：https://leetcode.cn/problems/make-sum-divisible-by-p
 */
public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        long t = 0;
        for (int num : nums) {
            t += num;
        }
        if (t < p) {
            return -1;
        }
        int k = (int) (t % p);
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        Map<Integer, Integer> last = new HashMap<>(n, 1);
        int s = 0;
        int ans = Integer.MAX_VALUE;
        last.put(s, -1);
        for (int i = 0; i < n; i++) {
            s = (s + nums[i]) % p;
            last.put(s, i);
            ans = Math.min(ans, i - last.getOrDefault((s - k + p) % p, -n));
        }
        return ans < n ? ans : -1;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP app = new MakeSumDivisibleByP();
        System.out.println(app.minSubarray(ArrayUtils.array("[6,3,5,2]"), 9)); // 2
        System.out.println(app.minSubarray(ArrayUtils.array("[4,4,2]"), 7)); // -1
        System.out.println(app.minSubarray(array(loadTestcase("1590-testcase-1.txt")), 949467102));
        System.out.println(app.minSubarray(array("[8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2]"), 148));
    }

}
