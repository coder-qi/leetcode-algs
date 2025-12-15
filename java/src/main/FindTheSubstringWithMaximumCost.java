/**
 * 2606. 找到最大开销的子字符串：https://leetcode.cn/problems/find-the-substring-with-maximum-cost
 */
public class FindTheSubstringWithMaximumCost {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] costs = new int[26];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            costs[chars.charAt(i) - 'a'] = vals[i];
        }
        int ans = 0;
        int f = 0;
        for (char ch : s.toCharArray()) {
            f = Math.max(f, 0) + costs[ch - 'a'];
            ans = Math.max(ans, f);
        }
        return ans;
    }

}
