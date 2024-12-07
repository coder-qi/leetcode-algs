import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列：https://leetcode.cn/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {

    class MyQueue {

        private Deque<Integer> stack1 = new LinkedList<>();
        private Deque<Integer> stack2 = new LinkedList<>();

        public MyQueue() {
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            swap();
            return stack2.pop();
        }

        private void swap() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        public int peek() {
            swap();
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
