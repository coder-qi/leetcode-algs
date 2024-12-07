import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 重复的DNA序列：https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class RepeatedDnaSequences {

    private static final int L = 10;
    private static Map<Character, Integer> bits = new HashMap<>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n < L) {
            return result;
        }
        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x = (x << 2) | bits.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n - L; i++) {
            x = ((x << 2) | bits.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            if (cnt.compute(x, (k, v) -> v == null ? 1 : v + 1) == 2) {
                result.add(s.substring(i, i + L));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // [AAAAACCCCC, CCCCCAAAAA]
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        // [AAAAAAAAAA]
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

}
