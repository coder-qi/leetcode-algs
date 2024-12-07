import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路径：https://leetcode-cn.com/problems/simplify-path/
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder currentPath = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            while (i < path.length() && path.charAt(i) == '/') { i++; }
            while (i < path.length() && path.charAt(i) != '/') {
                currentPath.append(path.charAt(i));
                i++;
            }
            String str = currentPath.toString();
            currentPath.setLength(0);
            if (str.equals("..")) {
                if (!stack.isEmpty()) { stack.pop(); }
            } else if (!str.equals(".") && !str.isEmpty()) {
                stack.push(str);
            }
        }

        StringBuilder result = new StringBuilder("/");
        while (!stack.isEmpty()) {
            result.append(stack.removeLast()).append("/");
        }
        if (result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

}
