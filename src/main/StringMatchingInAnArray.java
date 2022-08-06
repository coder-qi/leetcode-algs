import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配：https://leetcode.cn/problems/string-matching-in-an-array/
 */
public class StringMatchingInAnArray {

    public static void main(String[] args) {
        // ["as","hero"]
        System.out.println(stringMatching(new String[] {"mass","as","hero","superhero"}));
        // ["et","code"]
        System.out.println(stringMatching(new String[] {"leetcode","et","code"}));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

}
