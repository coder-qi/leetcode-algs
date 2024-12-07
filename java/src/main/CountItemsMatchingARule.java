import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量：https://leetcode.cn/problems/count-items-matching-a-rule/
 */
public class CountItemsMatchingARule {

    public static void main(String[] args) {

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int ruleIndex = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2);
        for (List<String> item : items) {
            if (item.get(ruleIndex).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }

}
