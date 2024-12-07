import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排：https://leetcode.cn/problems/check-permutation-lcci/
 */
public class CheckPermutationLcci {

    public static void main(String[] args) {

    }

    public static boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}
