package util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceUtils {

    public static String loadTestcase(String name) {
        try {
            return Files.readString(Paths.get(
                ResourceUtils.class.getClassLoader()
                    .getResource("testcase/" + name).toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
