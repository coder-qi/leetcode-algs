import java.util.HashMap;
import java.util.Map;

/**
 * 3137. K 周期字符串需要的最少操作次数：https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic
 */
public class MinimumNumberOfOperationsToMakeWordKPeriodic {

    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        int n = word.length();
        int max = 0;
        for (int i = 0; i < n; i += k) {
            String s = word.substring(i, i + k);
            int count = countMap.getOrDefault(s, 0) + 1;
            max = Math.max(max, count);
            countMap.put(s, count);
        }
        return n / k - max;
    }

}
