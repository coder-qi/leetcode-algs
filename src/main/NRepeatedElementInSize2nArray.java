import java.util.Random;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2nArray {

    public static int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        while (true) {
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if (i != j && nums[i] == nums[j]) {
                return nums[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] {1,2,3,3})); // 3
        System.out.println(repeatedNTimes(new int[] {2,1,2,5,3,2})); // 2
        System.out.println(repeatedNTimes(new int[] {5,1,5,2,5,3,5,4})); // 5

    }

}
