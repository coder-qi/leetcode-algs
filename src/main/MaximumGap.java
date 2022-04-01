import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int bucketNum = n, d = Math.max(max - min, 1);
        List<Integer>[] buckets = new List[bucketNum];
        for (int i = 0; i < n; i++) {
            int index = (int) ((nums[i] - min) * ((long)(bucketNum - 1)) / d);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(nums[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);
            }
        }
        int result = 0, preNum = Integer.MAX_VALUE;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (int num : bucket) {
                    result = Math.max(result, num - preNum);
                    preNum = num;
                }
            }
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
