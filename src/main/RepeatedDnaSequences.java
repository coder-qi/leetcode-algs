import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列：https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class RepeatedDnaSequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> sequences = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (!sequences.add(seq)) {
                result.add(seq);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        // [AAAAACCCCC, CCCCCAAAAA]
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        // [AAAAAAAAAA]
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

}
