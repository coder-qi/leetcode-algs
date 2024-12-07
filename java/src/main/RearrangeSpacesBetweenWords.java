import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格：https://leetcode.cn/problems/rearrange-spaces-between-words/
 */
public class RearrangeSpacesBetweenWords {

    public static void main(String[] args) {

    }

    public static String reorderSpaces(String text) {
        int totalSpaceCount = 0;
        List<String> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                totalSpaceCount++;
                if (temp.length() > 0) {
                    words.add(temp.toString());
                }
                temp.setLength(0);
            } else {
                temp.append(ch);
            }
        }
        if (temp.length() > 0) {
            words.add(temp.toString());
        }

        StringBuilder ans = new StringBuilder();
        int connectedSpaceCount = words.size() <= 1 ? 0 : totalSpaceCount / (words.size() - 1);
        for (String word : words) {
            if (ans.length() > 0) {
                for (int i = 0; i < connectedSpaceCount; i++) {
                    ans.append(' ');
                }
            }
            ans.append(word);
        }
        for (int i = 0; i < totalSpaceCount - (words.size() - 1) * connectedSpaceCount; i++) {
            ans.append(' ');
        }
        return ans.toString();
    }

}
