package biweekly.w76;

/**
 * 6061. 买钢笔和铅笔的方案数：https://leetcode-cn.com/problems/number-of-ways-to-buy-pens-and-pencils/
 */
public class NumberOfWaysToBuyPensAndPencils {

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; total >= 0; i++, total -= cost1) {
            ans += total / cost2 + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(20, 10, 5));
        System.out.println(waysToBuyPensPencils(1000000, 1, 1));
    }

}
