import java.util.HashMap;
import java.util.Map;

/**
 * 课程表：https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {

    Map<Integer, Node> nodes = new HashMap<>();
    int[][] prerequisites;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }
        this.prerequisites = prerequisites;
        for (int i = 0; i < prerequisites.length; i++) {
            Node p = getNode(prerequisites[i][0]), q = getNode(prerequisites[i][1]);
            p.next = q;
        }

        boolean[] vis = new boolean[numCourses];
        for (Node node : nodes.values()) {
            if (!vis[node.val]) {
                vis[node.val] = true;
                Node slow = node, fast = node.next;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    vis[fast.val] = vis[fast.next.val] = true;
                    fast = fast.next.next;
                    if (slow == fast) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Node getNode(int x) {
        Node node = nodes.get(x);
        if (node == null) {
            node = new Node(x);
            nodes.put(x, node);
        }
        return node;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{
            {1,0}
        })); // true
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{
            {1,0},
            {0,1}
        })); // false
        System.out.println(new CourseSchedule().canFinish(5, new int[][]{
            {1,4},{2,4},{3,1},{3,2}
        })); // true
    }

}
