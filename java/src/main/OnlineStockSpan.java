import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. 股票价格跨度：https://leetcode.cn/problems/online-stock-span/
 */
public class OnlineStockSpan {

    public static void main(String[] args) {

    }

}

class StockSpanner {

    Deque<int[]> stack = new ArrayDeque<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int range = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            range += stack.pop()[1];
        }
        stack.push(new int[] {price, range});
        return range;
    }
}
