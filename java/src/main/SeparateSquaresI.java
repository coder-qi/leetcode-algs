import util.ArrayUtils;

/**
 * 3453. 分割正方形 I：https://leetcode.cn/problems/separate-squares-i
 */
public class SeparateSquaresI {

    public double separateSquares(int[][] squares) {
        double left = 0, right = 0;
        for (int[] square : squares) {
            right = Math.max(right, square[1] + square[2]);
        }
        for (int i = 0; i < 60; i++) {
            double mid = left + (right - left) / 2;
            if (check(squares, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean check(int[][] squares, double y) {
        double diff = 0;
        for (int[] square : squares) {
            double yi = square[1];
            double li = square[2];
            double area = li * li;
            if (y >= yi + li) {
                diff += area;
            } else if (y <= yi) {
                diff -= area;
            } else {
                double bottom = (y - yi) * li;
                diff += bottom;
                diff -= (area - bottom);
            }
        }
        return diff >= 0;
    }

    public static void main(String[] args) {
        SeparateSquaresI app = new SeparateSquaresI();
        System.out.println(app.separateSquares(ArrayUtils.matrix("[[0,0,1],[2,2,1]]")));
        System.out.println(app.separateSquares(ArrayUtils.matrix("[[0,0,2],[1,1,1]]")));
    }

}
