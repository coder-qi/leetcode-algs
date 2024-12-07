/**
 * 622. 设计循环队列：https://leetcode.cn/problems/design-circular-queue/
 */
public class DesignCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4
    }

}

class MyCircularQueue {

    int[] elements;
    int index = -1, size;

    public MyCircularQueue(int k) {
        elements = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        index = (index + 1) % elements.length;
        elements[index] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(index - size + 1 + elements.length) % elements.length];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
}