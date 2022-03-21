/**
 * 只出现一次的数字 II：https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            int mask = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,3,2}));
        System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));
    }

}
