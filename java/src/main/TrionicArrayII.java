/**
 * 3640. 三段式数组 II：https://leetcode.cn/problems/trionic-array-ii
 */
public class TrionicArrayII {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i <= n - 4;) {
            int l = i;
            // 跳过非严格递增段
            while (l + 1 < n && nums[l + 1] <= nums[l]) {
                l++;
            }
            long s1 = 0;
            // 第一段递增段 [l, p)必须包含p-1的子数组和的最大值
            int p = l;
            while (p + 1 < n && nums[p + 1] > nums[p]) {
                s1 = nums[p] + Math.max(s1, 0);
                p++;
            }
            // 第二段递减 [p, q)的和
            long s2 = 0;
            int q = p;
            while (q + 1 < n && nums[q + 1] < nums[q]) {
                s2 += nums[q];
                q++;
            }
            // 第三段递增 (q, r]必须包含q+1的子数组的最大值
            long s3 = Long.MIN_VALUE;
            long tol = 0;
            int r = q;
            while (r + 1 < n && nums[r + 1] > nums[r]) {
                r++;
                tol += nums[r];
                s3 = Math.max(s3, tol);
            }
            if (p != q && q != r) {
                ans = Math.max(ans, s1 + s2 + s3 + nums[q]);
            }
            i = q;
        }
        return ans;
    }

    public static void main(String[] args) {
        TrionicArrayII app = new TrionicArrayII();
        System.out.println(app.maxSumTrionic(new int[]{0,-2,-1,-3,0,2,-1}));
        System.out.println(app.maxSumTrionic(new int[]{1,4,2,7}));
    }

}
