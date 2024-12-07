package biweekly.w79;

import java.util.HashMap;
import java.util.Map;

/**
 * 6084. 最多单词数的发件人：https://leetcode.cn/problems/sender-with-largest-word-count/
 */
public class SenderWithLargestWordCount {

    public static String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            int cnt = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + cnt);
        }
        String ans = "";
        int wordCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > wordCount) {
                ans = entry.getKey();
                wordCount = entry.getValue();
            } else if (entry.getValue() == wordCount && entry.getKey().compareTo(ans) > 0) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
