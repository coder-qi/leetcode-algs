/**
 * 3838. 带权单词映射：https://leetcode.cn/problems/weighted-word-mapping
 */
public class WeightedWordMapping {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (int i = 0; i < word.length(); i++) {
                weight += weights[word.charAt(i) - 'a'];
            }
            str.append((char) ((25 - weight % 26) + 'a'));
        }
        return str.toString();
    }

}
