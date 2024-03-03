import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225. 用队列实现栈：https://leetcode.cn/problems/implement-stack-using-queues
 */
public class ImplementStackUsingQueues {

    class MyStack {

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        public MyStack() {
        }

        public void push(int x) {
            q1.addLast(x);
        }

        public int pop() {
            while (q1.size() > 1) {
                q2.addLast(q1.removeFirst());
            }
            int result = q1.removeFirst();
            swap();
            return result;
        }

        private void swap() {
            Deque<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.addLast(q1.removeFirst());
            }
            int result = q1.getFirst();
            q2.addLast(q1.removeFirst());
            swap();
            return result;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
