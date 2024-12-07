package weekly.w287;

import java.util.HashMap;
import java.util.Map;

/**
 * 2306. 公司命名：https://leetcode.cn/problems/naming-a-company/
 */
public class NamingACompany {

    public static long distinctNames(String[] ideas) {
        Map<String, Integer> group = new HashMap<>();
        int[][] bad = new int[26][26];
        int[] size = new int[26];
        for (String idea : ideas) {
            int index = idea.charAt(0) - 'a';
            String t = idea.substring(1);
            int mask = group.getOrDefault(t, 0);
            group.put(t, mask | 1 << index);

            size[index]++;
            for (int j = 0; j < 26; j++) {
                if ((mask >> j & 1) != 0) {
                    bad[index][j]++;
                    bad[j][index]++;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                ans += (long) (size[i] - bad[i][j]) * (size[j] - bad[i][j]);
            }
        }
        return ans * 2;
    }

    public static void main(String[] args) {

    }

}
