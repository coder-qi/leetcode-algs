import java.util.TreeMap;

/**
 * 3013. 将数组分成最小总代价的子数组 II：https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-ii
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostII {

    public long minimumCost(int[] nums, int k, int dist) {
        Container c = new Container(nums[0]);
        for (int i = 1; i < dist + 2; i++) {
            c.addToL(nums[i]);
        }
        c.adjustLSizeTo(k - 1);

        long ans = c.sumL;
        for (int i = dist + 2; i < nums.length; i++) {
            int out = nums[i - dist - 1];
            c.out(out);

            int in = nums[i];
            c.in(in);

            c.adjustLSizeTo(k - 1);

            ans = Math.min(ans, c.sumL);
        }
        return ans;
    }

    static class Container {
        TreeMap<Integer, Integer> L = new TreeMap<>(); // 窗口内前(k - 1)小的值
        TreeMap<Integer, Integer> R = new TreeMap<>(); // 窗口内其他的值
        long sumL;
        int sizeL;

        Container(int initSumL) {
            sumL = initSumL;
        }

        void addToL(int x) {
            sumL += x;
            sizeL++;
            L.merge(x, 1, Integer::sum);
        }

        void out(int x) {
            if (L.containsKey(x)) {
                remove(L, x);
                sumL -= x;
                sizeL--;
            } else {
                remove(R, x);
            }
        }

        void in(int x) {
            if (x < L.lastKey()) {
                addToL(x);
            } else {
                R.merge(x, 1, Integer::sum);
            }
        }

        void adjustLSizeTo(int k) {
            while (sizeL > k) {
                l2r();
            }
            while (sizeL < k) {
                r2l();
            }
        }

        void l2r() {
            int x = L.lastKey();
            remove(L, x);
            sumL -= x;
            sizeL--;
            R.merge(x, 1, Integer::sum);
        }

        void r2l() {
            int x = R.firstKey();
            remove(R, x);
            addToL(x);
        }

        void remove(TreeMap<Integer, Integer> tm, int x) {
            int cnt = tm.get(x);
            if (cnt > 1) {
                tm.put(x, cnt - 1);
            } else {
                tm.remove(x);
            }
        }

    }

    public static void main(String[] args) {
        DivideAnArrayIntoSubarraysWithMinimumCostII app = new DivideAnArrayIntoSubarraysWithMinimumCostII();
        System.out.println(app.minimumCost(new int[]{10,1,2,2,2,1}, 4, 3));
    }

}
