/**
 * 只出现一次的数字 II：https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,3,2}));
        System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));
    }

}
