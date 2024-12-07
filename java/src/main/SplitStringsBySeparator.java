import java.util.ArrayList;
import java.util.List;

/**
 * 2788. 按分隔符拆分字符串：https://leetcode.cn/problems/split-strings-by-separator/description/
 */
public class SplitStringsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>(words.size());
        for (String word : words) {
            int i = 0, j = 0;
            while (j <= word.length()) {
                if (j == word.length() || word.charAt(j) == separator) {
                    if (j != 0 && i != j) {
                        result.add(word.substring(i, j));
                    }
                    i = ++j;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

}
