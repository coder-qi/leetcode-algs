import java.util.Arrays;

/**
 * 3074. 重新分装苹果：https://leetcode.cn/problems/apple-redistribution-into-boxes
 */
public class AppleRedistributionIntoBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int x : apple) {
            sum += x;
        }
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum > 0) {
                ans++;
            }
            sum -= capacity[i];
        }
        return ans;
    }

}
