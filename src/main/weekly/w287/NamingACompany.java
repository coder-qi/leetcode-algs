package weekly.w287;

import java.util.HashSet;
import java.util.Set;

/**
 * 2306. 公司命名：https://leetcode.cn/problems/naming-a-company/
 */
public class NamingACompany {

    public static long distinctNames(String[] ideas) {
        Set<String> ideaSet = new HashSet<>();
        for (String idea : ideas) {
            ideaSet.add(idea);
        }
        int[][] count = new int[26][26];
        StringBuilder temp = new StringBuilder();
        for (String idea : ideas) {
            int i = idea.charAt(0) - 'a';
            temp.setLength(0);
            temp.append(idea);
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    continue;
                }
                temp.setCharAt(0, (char) (j + 'a'));
                if (!ideaSet.contains(temp.toString())) {
                    count[i][j]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans += count[i][j] * count[j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
