/**
 * 3513. 不同 XOR 三元组的数目 I：https://leetcode.cn/problems/number-of-unique-xor-triplets-i
 */
public class NumberOfUniqueXorTripletsI {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        return n <= 2 ? n : 1 << (32 - Integer.numberOfLeadingZeros(n));
    }

}
