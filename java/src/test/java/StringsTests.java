import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static algorithm.Strings.removeChars;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTests {
    @Test
    @DisplayName("remove particular char from a string")
    void removeCharsTest() {
        assertEquals("stdent", removeChars("studuuenuut", 'u'));
    }
}