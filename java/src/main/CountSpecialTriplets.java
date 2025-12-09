import java.util.HashMap;
import java.util.Map;

/**
 * 3583. 统计特殊三元组：https://leetcode.cn/problems/count-special-triplets
 */
public class CountSpecialTriplets {

    public int specialTriplets(int[] nums) {
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(n, 1);
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];
        for (int i = 0; i < n; i++) {
            leftCount[i] = cnt.getOrDefault(nums[i] * 2, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        cnt.clear();
        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = cnt.getOrDefault(nums[i] * 2, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) leftCount[i] * rightCount[i];
        }
        res %= mod;
        return (int) res;
    }

    public static void main(String[] args) {
        CountSpecialTriplets app = new CountSpecialTriplets();
        System.out.println(app.specialTriplets(new int[]{0,1,0,0})); // 1
        System.out.println(app.specialTriplets(new int[]{56,56,87,28,55,56,94})); // 2
    }

}
