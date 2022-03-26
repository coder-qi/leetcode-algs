import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存：https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    Node head, tail;
    Map<Integer, Node> nodes = new HashMap<>();
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = nodes.get(key);
        if (node != null) {
            moveToFirst(node);
            return node.val;
        }
        return -1;
    }

    private void moveToFirst(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            Node prev = tail.prev;
            tail.prev = null;
            prev.next = null;
            tail = prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void addFirst(int key, int value) {
        if (size == 0) {
            head = tail = new Node(key, value);
        } else {
            Node node = new Node(key, value);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        nodes.put(key, head);
        size++;
    }

    private void removeLastIfFully() {
        if (size == capacity) {
            Node prev = tail.prev;
            nodes.remove(tail.key);
            if (prev == null) {
                head = tail = null;
            } else {
                tail.prev = null;
                prev.next = null;
                tail = prev;
            }
            size--;
        }
    }

    public void put(int key, int value) {
        Node node = nodes.get(key);
        if (node != null) {
            node.val = value;
            moveToFirst(node);
        } else {
            removeLastIfFully();
            addFirst(key, value);
        }
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4


        lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        lRUCache.get(2);
        lRUCache.put(3, 2);
        lRUCache.get(2);
        lRUCache.get(3);
    }

}
