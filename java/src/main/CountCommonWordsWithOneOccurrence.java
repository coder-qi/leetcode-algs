import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 2085. 统计出现过一次的公共字符串：https://leetcode.cn/problems/count-common-words-with-one-occurrence/description/
 */
public class CountCommonWordsWithOneOccurrence {

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> countMap1 = new HashMap<>(8);
        BiFunction<String, Integer, Integer> incrementFunction = (k, v) -> v == null ? 1 : v + 1;
        for (String word : words1) {
            countMap1.compute(word, incrementFunction);
        }
        Map<String, Integer> countMap2 = new HashMap<>(8);
        for (String word : words2) {
            countMap2.compute(word, incrementFunction);
        }
        int ans = 0;
        if (countMap2.size() < countMap1.size()) {
            Map<String, Integer> temp = countMap1;
            countMap1 = countMap2;
            countMap2 = temp;
        }
        for (Map.Entry<String, Integer> entry : countMap1.entrySet()) {
            if (entry.getValue() == 1 && countMap2.getOrDefault(entry.getKey(), 0) == 1) {
                ans++;
            }
        }
        return ans;
    }

}
