package book.chap11;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static book.chap11.ReadPositiveIntParam.readDurationImperative;
import static book.chap11.ReadPositiveIntParam.readDurationWithOptional;
import static org.junit.jupiter.api.Assertions.*;

class ReadPositiveIntParamTest {

    @Test
    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));
    }

}
