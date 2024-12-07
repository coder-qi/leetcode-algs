import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 535. TinyURL 的加密与解密：https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */
public class EncodeAndDecodeTinyurl {

    static class Codec {

        static Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int index = longUrl.indexOf("//");
            index = longUrl.indexOf("/", index + 2);
            if (index == -1) {
                return longUrl;
            }
            String path = longUrl.substring(index + 1);
            if (map.containsKey(path)) {
                return map.get(path);
            }
            String id = UUID.randomUUID().toString().replace("-", "");
            map.put(id, path);
            return longUrl.substring(0, index + 1) + id;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int index = shortUrl.indexOf("//");
            index = shortUrl.indexOf("/", index + 2);
            if (index == -1) {
                return shortUrl;
            }
            String id = shortUrl.substring(index + 1);
            return shortUrl.substring(0, index + 1) + map.get(id);
        }
    }

    public static void main(String[] args) {
        Codec obj = new Codec();
        String tiny = obj.encode("https://leetcode.com/problems/design-tinyurl"); // 返回加密后得到的 TinyURL 。
        String ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
        System.out.println(tiny + " -> " + ans);
    }


}
