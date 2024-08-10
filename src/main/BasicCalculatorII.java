import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器 II：https://leetcode.cn/problems/basic-calculator-ii
 */
public class BasicCalculatorII {

    public static int calculate(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else {
                addNum(stack, num);
                stack.push(ch);
                num = 0;
            }
        }
        addNum(stack, num);

        return getNum(stack);
    }

    private static int getNum(Deque<Object> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            int num = (int) stack.pop();
            boolean add = stack.isEmpty() || stack.pop().equals('+');
            res += add ? num : -num;
        }
        return res;
    }

    private static void addNum(Deque<Object> stack, int num) {
        if (!stack.isEmpty()) {
            char op = (char) stack.peek();
            if (op == '*' || op == '/') {
                stack.pop();
                int x = (int) stack.pop();
                num = op == '*' ? x * num : x / num;
            }
        }
        stack.push(num);
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
    }

}
