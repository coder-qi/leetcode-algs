import java.util.*;

/**
 * 3318. 计算子数组的 x-sum I：https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/
 */
public class FindXSumOfAllKLongSubarraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        int[] res = new int[Math.max(1, nums.length - k + 1)];
        for (int i = 0, j = 0; j < nums.length; j++) {
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            if (j - i + 1 == k || (k <= nums.length && j == nums.length - 1)) {
                res[i] = sum(count, x);
                int c = count.get(nums[i]);
                if (c <= 1) {
                    count.remove(nums[i]);
                } else {
                    count.put(nums[i], c - 1);
                }
                i++;
            }
        }
        return res;
    }

    private int sum(Map<Integer, Integer> count, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                int c1 = count.get(num1);
                int c2 = count.get(num2);
                return c1 != c2 ? Integer.compare(c2, c1) : Integer.compare(num2, num1);
            }
        });
        for (int num : count.keySet()) {
            pq.add(num);
        }
        int sum = 0;
        for (int i = 0; i < x && !pq.isEmpty(); i++) {
            int num = pq.poll();
            sum += num * count.get(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysI app = new FindXSumOfAllKLongSubarraysI();
        System.out.println(Arrays.toString(app.findXSum(new int[]{9,2,2}, 3, 3)));
    }

}
