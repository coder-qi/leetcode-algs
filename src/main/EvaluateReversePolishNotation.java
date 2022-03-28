import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 逆波兰表达式求值：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    static Map<String, BiFunction<Integer, Integer, Integer>> operators = Map.of(
        "+", (x, y) -> x + y,
        "-", (x, y) -> x - y,
        "*", (x, y) -> x * y,
        "/", (x, y) -> x / y
    );

    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            BiFunction f = operators.get(token);
            if (f != null) {
                int y = Integer.valueOf(stack.pop());
                int x = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(f.apply(x, y)));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
