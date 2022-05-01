package biweekly.w77;

public class CountPrefixesOfAGivenString {

    public static int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
