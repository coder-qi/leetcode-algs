import java.util.Arrays;

/**
 * 最大间距：https://leetcode-cn.com/problems/maximum-gap/
 */
public class MaximumGap {

    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int d = Math.max((max - min) / (n - 1), 1), bucketSize = (max - min) / d + 1;
        int[][] buckets = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(buckets[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - min) / d;
            if (buckets[index][0] == -1) {
                buckets[index][0] = buckets[index][1] = nums[i];
            } else {
                buckets[index][0] = Math.min(buckets[index][0], nums[i]);
                buckets[index][1] = Math.max(buckets[index][1], nums[i]);
            }
        }
        int result = 0;
        for (int i = 0, prev = -1; i < bucketSize; i++) {
            if (buckets[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                result = Math.max(result, buckets[i][0] - buckets[prev][1]);
            }
            prev = i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumGap(new int[] {3,6,9,1}));
        System.out.println(maximumGap(new int[] {10}));
        System.out.println(maximumGap(new int[] {1,1,1,1}));
        System.out.println(maximumGap(new int[] {494767408,862126209,213511142,768240025,631263193,839199222,990848796,214568815,540853864,760724418,980162605,976743981,168965760,680875496,256709197,970953816,948680062,347254784,732201399,786249847,782805044,40906641,674241381,784330934,175502610,731105392,424650824,549764101,986090032,710542549,249208107,448419816,527708664,158499246,223421723,114552457,466978424,821491411,19614107,115389497,902211438,2644108,744489871,897895073,372311214,551142753,933294894,426217662,217504874,983488406,516890023,426853110,971124103}));
    }

}
