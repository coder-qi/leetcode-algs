import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */
public class MeanOfArrayAfterRemovingSomeElements {

    public static void main(String[] args) {

    }

    public static double trimMean(int[] arr) {
        int n = arr.length, d = n / 20;
        Arrays.sort(arr);
        double sum = 0;
        for (int i = d; i < n - d; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * d);
    }

}
