import java.util.*;

/**
 * 3321. 计算子数组的 x-sum II：https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-ii
 */
public class FindXSumOfAllKLongSubarraysII {

    Map<Integer, Node> numMap = new HashMap<>();
    TreeSet<Node> small = new TreeSet<>();
    TreeSet<Node> lagre = new TreeSet<>();
    int x;
    long sum = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        this.x = x;

        long[] res = new long[nums.length - k + 1];
        for (int i = 0, j = 0; j < nums.length; j++) {
            add(nums[j]);
            if (j - i + 1 == k) {
                res[i] = sum;
                remove(nums[i]);
                i++;
            }
        }
        return res;
    }

    private void add(int num) {
        Node node = numMap.get(num);
        if (node == null) {
            node = new Node(num, 1);
            numMap.put(num, node);
            doAdd(node);
        } else {
            doRemove(node);
            node.count++;
            doAdd(node);
        }
    }

    private void remove(int num) {
        Node node = numMap.get(num);
        doRemove(node);
        node.count--;
        doAdd(node);
    }

    private void doAdd(Node node) {
        if (lagre.size() < x || node.compareTo(lagre.first()) > 0) {
            sum += (long) node.num * node.count;
            lagre.add(node);
            if (lagre.size() > x) {
                Node toRemoved = lagre.first();
                sum -= (long) toRemoved.num * toRemoved.count;
                lagre.remove(toRemoved);
                small.add(toRemoved);
            }
        } else {
            small.add(node);
        }
    }

    private void doRemove(Node node) {
        if (node.compareTo(lagre.first()) >= 0) {
            sum -= (long) node.num * node.count;
            lagre.remove(node);
            if (!small.isEmpty()) {
                Node toAdd = small.last();
                sum += (long) toAdd.num * toAdd.count;
                small.remove(toAdd);
                lagre.add(toAdd);
            }
        } else {
            small.remove(node);
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node node)) return false;
            return num == node.num && count == node.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, count);
        }

        @Override
        public int compareTo(Node o) {
            return this.count != o.count ? Integer.compare(this.count, o.count) : Integer.compare(this.num, o.num);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysII app = new FindXSumOfAllKLongSubarraysII();
        System.out.println(Arrays.toString(app.findXSum(new int[]{2,1,2,5,1,6,5,2,5}, 8, 7)));
    }

}
