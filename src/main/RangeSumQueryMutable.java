/**
 * 307. 区域和检索 - 数组可修改：https://leetcode.cn/problems/range-sum-query-mutable/
 */
public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2));; // 返回 1 + 2 + 5 = 8
    }

}

class NumArray {

    int[] nums, sum;
    int size;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n + size - 1) / size];
        for (int i = 0; i < n; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
        if (b1 == b2) {
            int sum = 0;
            for (int i = i1; i <= i2; i++) {
                sum += nums[b1 * size + i];
            }
            return sum;
        }
        int sum1 = 0;
        for (int i = i1; i < size; i++) {
            sum1 += nums[b1 * size + i];
        }
        int sum2 = 0;
        for (int i = 0; i <= i2; i++) {
            sum2 += nums[b2 * size + i];
        }
        int sum3 = 0;
        for (int i = b1 + 1; i < b2; i++) {
            sum3 += sum[i];
        }
        return sum1 + sum2 + sum3;
    }
}
