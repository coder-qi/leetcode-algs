/**
 * 最后一个单词的长度：https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 5
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
    }

}
