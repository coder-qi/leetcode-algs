import java.util.Deque;
import java.util.LinkedList;

/**
 * 388. 文件的最长绝对路径：https://leetcode-cn.com/problems/longest-absolute-file-path/
 */
public class LongestAbsoluteFilePath {

    public static int lengthLongestPath(String input) {
        int n = input.length(), ans = 0;
        int pos = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (pos < n) {
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                len++;
            }
            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(lengthLongestPath("a"));
        System.out.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

}
