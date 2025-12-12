package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static List<List<String>> toNested(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        s = s.replaceAll("\"", "");
        String[] items = s.split("\\]\\s*,\\s*");
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            result.add(to(items[i] + (i != items.length - 1 ? "]" : "")));
        }
        return result;
    }

    public static List<String> to(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        String[] items = s.split("\\s*,\\s*");
        return Arrays.asList(items);
    }

}
