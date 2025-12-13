import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 3606. 优惠券校验器：https://leetcode.cn/problems/coupon-code-validator
 */
public class CouponCodeValidator {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        Set<String> bizs = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        List<String[]> coupons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isActive[i] && bizs.contains(businessLine[i]) && code[i].matches("^\\w+$")) {
                coupons.add(new String[] { businessLine[i], code[i] });
            }
        }
        coupons.sort((o1, o2) -> {
            if (o1[0].charAt(0) != o2[0].charAt(0)) {
                return o1[0].compareTo(o2[0]);
            }
            return o1[1].compareTo(o2[1]);
        });
        return coupons.stream()
                .map(o -> o[1])
                .collect(Collectors.toList());
    }

    public List<String> validateCoupons2(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        Set<String> bizs = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        PriorityQueue<String[]> pq = new PriorityQueue<>(n, (o1, o2) -> {
            if (o1[0].charAt(0) != o2[0].charAt(0)) {
                return o1[0].compareTo(o2[0]);
            }
            return o1[1].compareTo(o2[1]);
        });
        for (int i = 0; i < n; i++) {
            if (isActive[i] && bizs.contains(businessLine[i]) && code[i].matches("^\\w+$")) {
                pq.offer(new String[] { businessLine[i], code[i] });
            }
        }
        List<String> ans = new ArrayList<>(pq.size());
        while (!pq.isEmpty()) {
            String[] cur = pq.poll();
            ans.add(cur[1]);
        }
        return ans;
    }

}
