/**
 * 颠倒字符串中的单词：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int n = s.length(), right = n - 1;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            if (right >= 0) {
                result.append(s, left + 1, right + 1).append(' ');
            }
            right = left;
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

}
