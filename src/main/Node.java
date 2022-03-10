import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node of(Integer... nums) {
        Node root = new Node(nums[0]);
        Queue<Node> stack = new LinkedList<>();
        stack.offer(root);
        int i = 1;
        while (i < nums.length && !stack.isEmpty()) {
            Integer num = nums[i++];
            Node node = stack.poll();
            if (num != null) {
                Node left = new Node(num);
                node.left = left;
                stack.offer(left);
            }
            if (i < nums.length) {
                num = nums[i++];
                if (num != null) {
                    Node right = new Node(num);
                    node.right = right;
                    stack.offer(right);
                }
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}