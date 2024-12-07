import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

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
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            BiFunction<Integer, Integer, Integer> f = operators.get(token);
            if (f != null) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(f.apply(x, y));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
