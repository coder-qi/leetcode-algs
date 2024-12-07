import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import graph.Node;

/**
 * 克隆图：https://leetcode-cn.com/problems/clone-graph/
 */
public class CloneGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> nodes = new HashMap<>();
        nodes.put(1, new Node(1));
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node x = q.poll();
            Node cloneNode = nodes.get(x.val);
            for (Node neighbor : x.neighbors) {
                Node cloneNeighbor = nodes.get(neighbor.val);
                if (cloneNeighbor == null) {
                    q.offer(neighbor);
                    cloneNeighbor = new Node(neighbor.val);
                    nodes.put(cloneNeighbor.val, cloneNeighbor);
                }
                cloneNode.neighbors.add(cloneNeighbor);
            }
        }
        return nodes.get(1);
    }

    static Node createGraph(int n) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i + 1));
        }
        if (n > 1) {
            nodes.get(0).neighbors.add(nodes.get(1));
            if (n > 2) {
                nodes.get(0).neighbors.add(nodes.get(nodes.size() - 1));
            }

            nodes.get(nodes.size() - 1).neighbors.add(nodes.get(0));
            if (n > 2) {
                nodes.get(nodes.size() - 1).neighbors.add(nodes.get(nodes.size() - 2));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            nodes.get(i).neighbors.add(nodes.get(i - 1));
            nodes.get(i).neighbors.add(nodes.get(i + 1));
        }

        return nodes.get(0);
    }

    public static void main(String[] args) {
        System.out.println(cloneGraph(createGraph(4)));
    }

}
