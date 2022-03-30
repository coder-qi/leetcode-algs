import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈：https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    Deque<Integer> valStack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
    }
    
    public void push(int val) {
        valStack.push(val);
        int min = minStack.isEmpty() || val < minStack.peek() ? val : minStack.peek();
        minStack.push(min);
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}