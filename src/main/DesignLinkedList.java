/**
 * 707. 设计链表：https://leetcode.cn/problems/design-linked-list/
 */
public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }

}

class MyLinkedList {

    Node head, tail;

    int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (!checkIndex(index)) {
            return -1;
        }
        return getNode(index).val;
    }

    boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    Node getNode(int index) {
        if (index < (size >> 1)) {
            Node x = head.next;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = tail.prev;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public void addAtHead(int val) {
        Node x = new Node(val);
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        x.prev = head;
        size++;
    }

    public void addAtTail(int val) {
        Node x = new Node(val);
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
        x.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (checkIndex(index)) {
            Node x = new Node(val);
            Node cur = getNode(index);
            x.prev = cur.prev;
            cur.prev.next = x;
            cur.prev = x;
            x.next = cur;
            size++;
        } else if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (checkIndex(index)) {
            Node cur = getNode(index);
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            size--;
        }
    }

    static class Node {
        int val;
        Node prev, next;
        public Node(int val) {
            this.val = val;
        }
    }
}