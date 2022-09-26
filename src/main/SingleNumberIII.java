import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III：https://leetcode.cn/problems/single-number-iii/
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[] {1,2,1,3,2,5}))); // [3,5]
        System.out.println(Arrays.toString(singleNumber(new int[] {-1,0}))); // [-1,0]
        System.out.println(Arrays.toString(singleNumber(new int[] {0,1}))); // [0,1]
    }

    public static int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int lsb = x & -x;
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[] {type1, type2};
    }

}
