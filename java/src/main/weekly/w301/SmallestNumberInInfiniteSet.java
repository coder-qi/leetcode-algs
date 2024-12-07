package weekly.w301;

import java.util.TreeSet;

/**
 * 6113. 无限集中的最小数字：https://leetcode.cn/problems/smallest-number-in-infinite-set/
 */
public class SmallestNumberInInfiniteSet {

    static class SmallestInfiniteSet {

        TreeSet<Integer> s = new TreeSet<>();

        public SmallestInfiniteSet() {
            for (int i = 1; i <= 1000; i++) {
                s.add(i);
            }
        }

        public int popSmallest() {
            int num = s.first();
            s.remove(num);
            return num;
        }

        public void addBack(int num) {
            s.add(num);
        }
    }


    public static void main(String[] args) {

    }

}
