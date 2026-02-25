import java.util.stream.IntStream;

/**
 * 1356. 根据数字二进制下 1 的数目排序：https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits
 */
public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted((a, b) -> {
                    int c1 = Integer.bitCount(a);
                    int c2 = Integer.bitCount(b);
                    return c1 == c2 ? Integer.compare(a, b) : Integer.compare(c1, c2);
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
