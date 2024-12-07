/**
 * 952. 按公因数计算最大组件大小：https://leetcode.cn/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSizeByCommonFactor {

    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[] {4,6,15,35})); // 4
        System.out.println(largestComponentSize(new int[] {20,50,9,63})); // 2
        System.out.println(largestComponentSize(new int[] {2,3,6,7,4,12,21,39})); // 8
    }

    public static int largestComponentSize(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        UnionFind uf = new UnionFind(max + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int ans = 0;
        int[] count = new int[max + 1];
        for (int num : nums) {
            int root = uf.find(num);
            count[root]++;
            ans = Math.max(ans, count[root]);
        }
        return ans;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
           parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
           rank = new int[n];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

}
