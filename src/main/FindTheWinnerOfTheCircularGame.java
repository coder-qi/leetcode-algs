/**
 * 1823. 找出游戏的获胜者：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinnerOfTheCircularGame {

    public static int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2)); // 3
        System.out.println(findTheWinner(6, 5)); //1
    }

}
