package weekly.w302;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6164. 数位和相等数对的最大和：https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 */
public class MaxSumOfAPairWithEqualSumOfDigits {

    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int p = 0;
            while (num != 0) {
                p += num % 10;
                num /= 10;
            }
            List<Integer> list = map.get(p);
            if (list == null) {
                list = new ArrayList<>();
                map.put(p, list);
            }
            list.add(nums[i]);
        }
        int ans = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            if (list.size() > 1) {
                ans = Math.max(ans, list.get(list.size() - 1) + list.get(list.size() - 2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
