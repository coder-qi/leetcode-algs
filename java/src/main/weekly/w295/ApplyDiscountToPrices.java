package weekly.w295;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * 6079. 价格减免：https://leetcode.cn/problems/apply-discount-to-prices/
 */
public class ApplyDiscountToPrices {

    static final Pattern PRICE_PATTERN = Pattern.compile("\\$\\d+");

    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#0.00");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (PRICE_PATTERN.matcher(word).matches()) {
                double price = Long.parseLong(word.substring(1)) * (100 - discount) / 100.0d;
                ans.append("$" + df.format(price)).append(" ");
            } else {
                ans.append(word).append(" ");
            }
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(discountPrices("ka3caz4837h6ada4 r1 $602", 9));
    }

}
