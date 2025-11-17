/**
 * 1437. 是否所有 1 都至少相隔 k 个元素：https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last != -1 && i - last - 1 < k) {
                    return false;
                }
                last = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfAll1sAreAtLeastLengthKPlacesAway app = new CheckIfAll1sAreAtLeastLengthKPlacesAway();
        app.kLengthApart(new int[]{1,0,0,1,0,1}, 2);
    }

}
