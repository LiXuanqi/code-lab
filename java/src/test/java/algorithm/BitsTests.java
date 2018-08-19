package algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static algorithm.Bits.setKthBitTo1;
import static algorithm.Bits.setKthBitTo0;
public class BitsTests {
    @Test
    void setKthBitTo1Test() {
        assertEquals(3, setKthBitTo1(1, 1));
    }
    @Test
    void setKthBitTo0Test() {
        assertEquals(0, setKthBitTo0(2, 1));
    }
}
