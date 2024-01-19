import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2809. 使数组和小于等于 x 的最少时间：https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/description/
 */
public class MinimumTimeToMakeArraySumAtMostX {

    public static int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        // TODO 待做
        long sum1 = sum(nums1);
        if (sum1 <= x) {
            return 0;
        }
        long sum2 = sum(nums2);
        int n = nums1.size();
        int[][] sortedNums2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums2[i][0] = i;
            sortedNums2[i][1] = nums2.get(i);
        }
        Arrays.sort(sortedNums2, ((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : nums1.get(o1[0]).compareTo(nums1.get(o2[0]))));
        for (int i = 0, ans = 0; i < n; i++) {
            if (sortedNums2[i][1] == 0) {
                continue;
            }
            ans++;
            sum1 += sum2;
            sum1 -= nums1.get(sortedNums2[i][0]) + (long) (i + 1) * sortedNums2[i][1];
            if (sum1 <= x) {
                return ans;
            }
        }
        return -1;
    }

    private static long sum(List<Integer> nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(Arrays.asList(4,4,9,10), Arrays.asList(4,4,1,3), 16)); // 4
        System.out.println(minimumTime(Arrays.asList(7,9,8,5,8,3), Arrays.asList(0,1,4,2,3,1), 37)); // 2
    }
}
