import static util.ArrayUtils.array;

/**
 * 875. 爱吃香蕉的珂珂：https://leetcode.cn/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int totalH = 0;
            for (int pile : piles) {
                totalH += (pile + mid - 1) / mid;
            }
            if (totalH <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(array("[3,6,7,11]"), 8)); // 4
        System.out.println(minEatingSpeed(array("[30,11,23,4,20]"), 5)); // 30
        System.out.println(minEatingSpeed(array("[30,11,23,4,20]"), 6)); // 23
    }

}
