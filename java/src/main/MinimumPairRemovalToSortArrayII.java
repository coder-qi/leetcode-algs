import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 3510. 移除最小数对使数组有序 II：https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/
 */
public class MinimumPairRemovalToSortArrayII {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        TreeSet<Pair> ts = new TreeSet<>();
        TreeSet<Integer> idx = new TreeSet<>();
        int dec = 0;
        long[] a = new long[n];
        for (int i = 0; i < n - 1; i++) {
            idx.add(i);
            a[i] = nums[i];
            ts.add(new Pair(nums[i] + nums[i + 1], i));
            if (nums[i] > nums[i + 1]) {
                dec++;
            }
        }
        a[n - 1] = nums[n - 1];
        idx.add(n - 1);
        while (dec > 0) {
            Pair pair = ts.removeFirst();
            long s = pair.s;
            int i = pair.i;
            Integer pre = idx.floor(i - 1);
            int next = idx.ceiling(i + 1);
            Integer next2 = idx.ceiling(next + 1);
            if (pre != null) {
                if (a[pre] > a[i]) {
                    dec--;
                }
                if (a[pre] > s) {
                    dec++;
                }
                ts.remove(new Pair(a[pre] + a[i], pre));
                ts.add(new Pair(s + a[pre], pre));
            }
            if (a[i] > a[next]) {
                dec--;
            }
            if (next2 != null) {
                if (a[next] > a[next2]) {
                    dec--;
                }
                if (s > a[next2]) {
                    dec++;
                }
                ts.remove(new Pair(a[next] + a[next2], next));
                ts.add(new Pair(s + a[next2], i));
            }
            a[i] = s;
            idx.remove(next);
        }
        return n - idx.size();
    }

    public int minimumPairRemoval2(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(n);
        long[] a = new long[n];
        int dec = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                dec++;
            }
            pq.add(new Pair(nums[i] + nums[i + 1], i));
            a[i] = nums[i];
        }
        a[n - 1] = nums[n - 1];

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }
        int ans = 0;
        while (dec > 0) {
            ans++;
            while (right[pq.peek().i] >= n || pq.peek().s != a[pq.peek().i] + a[right[pq.peek().i]]){
                pq.poll();
            }

            Pair pair = pq.poll();
            long s = pair.s;
            int i = pair.i;
            int pre = left[i];
            int next = right[i];
            int next2 = right[next];

            if (pre >= 0) {
                if (a[pre] > a[i]) {
                    dec--;
                }
                if (a[pre] > s) {
                    dec++;
                }
                pq.offer(new Pair(s + a[pre], pre));
            }
            if (a[i] > a[next]) {
                dec--;
            }
            if (next2 < n) {
                if (a[next] > a[next2]) {
                    dec--;
                }
                if (s > a[next2]) {
                    dec++;
                }
                pq.add(new Pair(s + a[next2], i));
            }
            a[i] = s;
            int l = left[next];
            int r = right[next];
            right[l] = r;
            left[r] = l;
            right[next] = n;
            left[next] = -2;
        }
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        long s;
        int i;

        public Pair(long s, int i) {
            this.s = s;
            this.i = i;
        }

        @Override
        public int compareTo(Pair o) {
            return this.s == o.s ? Integer.compare(this.i, o.i) : Long.compare(this.s, o.s);
        }
    }

    public static void main(String[] args) {
        MinimumPairRemovalToSortArrayII app = new MinimumPairRemovalToSortArrayII();
        System.out.println(app.minimumPairRemoval2(new int[]{5, 2, 3, 1}));
    }

}
