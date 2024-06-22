package book.chap11;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.*;

public class ReadPositiveIntParam {

    public static int readDurationImperative(Properties props, String name) {
        String property = props.getProperty(name);
        if (property != null) {
            try {
                int i = Integer.parseInt(property);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return 0;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return ofNullable(props.getProperty(name))
                .flatMap(ReadPositiveIntParam::parseIntWithOptional)
                .filter(i -> i > 0).orElse(0);
    }

    public static Optional<Integer> parseIntWithOptional(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

}
