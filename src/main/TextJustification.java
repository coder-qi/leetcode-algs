import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐：https://leetcode-cn.com/problems/text-justification/
 */
public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, left = 0, pos = 0, width = 0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (left < n) {
            if (pos > n - 1 || width + 1 + words[pos].length() > maxWidth) {
                int totalSpaces = maxWidth - width;
                int space = pos > n - 1 ? 0 : totalSpaces / Math.max(1, pos - 1 - left);
                int remainingSpace = pos > n - 1 ? 0 : totalSpaces % Math.max(1, pos - 1 - left);
                for (int i = left; i < pos; i++) {
                    sb.append(words[i]);
                    if (i != pos - 1) {
                        sb.append(' ');
                        appendSpace(sb, space + (remainingSpace > 0 ? 1 : 0));
                    } else if (pos > n - 1 || pos - left == 1) {
                        appendSpace(sb, totalSpaces);
                    }

                    if (remainingSpace > 0) {
                        remainingSpace--;
                    }
                }
                if (sb.length() > 0) {
                    result.add(sb.toString());
                }
                sb.setLength(0);

                left = pos;
                width = 0;
            }
            if (width > 0) {
                width += 1;
            }
            if (pos < n) {
                width += words[pos].length();
            }
            pos++;
        }
        return result;
    }

    private static void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }

    private static String printPretty(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < strs.size(); i++) {
            sb.append("\t\"" + strs.get(i) + "\"");
            if (i != strs.size() - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printPretty(
            fullJustify(new String[]{ "This", "is", "an", "example", "of", "text", "justification." },
                16)));
        System.out.println(printPretty(
            fullJustify(new String[]{ "What","must","be","acknowledgment","shall","be" },
                16)));
        System.out.println(printPretty(
            fullJustify(new String[]{ "Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"},
                20)));
        System.out.println(printPretty(
            fullJustify(new String[]{ "Listen","to","many,","speak","to","a","few." },
                6)));
    }

}
