import java.util.Arrays;
import java.util.Random;

/**
 * 1206. 设计跳表：https://leetcode.cn/problems/design-skiplist/
 */
public class DesignSkiplist {

    public static void main(String[] args) {

    }

}

class Skiplist {

    static final int MAX_LEVEL = 32;
    static final double P_FACTOR = 0.25;
    Node head;
    int level;
    Random random = new Random();

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node[] upload = new Node[MAX_LEVEL];
        Arrays.fill(upload, head);
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            upload[i] = curr;
        }
        int lv = randomLevel();
        level = Math.max(level, lv);
        Node newNode = new Node(num, lv);
        for (int i = 0; i < lv; i++) {
            newNode.forward[i] = upload[i].forward[i];
            upload[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] upload = new Node[MAX_LEVEL];
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            upload[i] = curr;
        }
        curr = curr.forward[0];
        if (curr == null || curr.val != num) {
            return false;
        }
        for (int i = 0; i < level; i++) {
            if (upload[i].forward[i] != curr) {
                break;
            }
            upload[i].forward[i] = curr.forward[i];
        }
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    int randomLevel() {
        int lv = 1;
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    static class Node {
        int val;
        Node[] forward;

        public Node(int val, int maxLevel) {
            this.val = val;
            forward = new Node[maxLevel];
        }
    }

}