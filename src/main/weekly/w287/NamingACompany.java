package weekly.w287;

import java.util.HashMap;
import java.util.Map;

/**
 * 2306. 公司命名：https://leetcode.cn/problems/naming-a-company/
 */
public class NamingACompany {

    public static long distinctNames(String[] ideas) {
        Map<String, Integer> group = new HashMap<>();
        for (String idea : ideas) {
            String s = idea.substring(1);
            group.put(s, group.getOrDefault(s, 0) | 1 << (idea.charAt(0) - 'a'));
        }
        long ans = 0;
        int[][] count = new int[26][26];
        for (int mask : group.values()) {
            for (int i = 0; i < 26; i++) {
                if ((mask >> i & 1) != 0) {
                    for (int j = 0; j < 26; j++) {
                        if ((mask >> j & 1) == 0) {
                            count[i][j]++;
                        }
                    }
                } else {
                    for (int j = 0; j < 26; j++) {
                        if ((mask >> j & 1) != 0) {
                            ans += count[i][j];
                        }
                    }
                }
            }
        }
        return ans * 2;
    }

    public static void main(String[] args) {

    }

}
