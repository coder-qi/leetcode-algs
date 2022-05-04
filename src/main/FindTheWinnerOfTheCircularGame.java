import java.util.ArrayList;
import java.util.List;

/**
 * 1823. 找出游戏的获胜者：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinnerOfTheCircularGame {

    public static int findTheWinner(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int start = 0;
        while (nums.size() > 1) {
            start = (k + start - 1) % nums.size();
            nums.remove(start);
        }
        return nums.get(0);
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2)); // 3
        System.out.println(findTheWinner(6, 5)); //1
    }

}
