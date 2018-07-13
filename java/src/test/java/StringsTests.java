import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static algorithm.Strings.removeChars;
import static algorithm.Strings.removeExtraSpaces;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTests {
    @Test
    @DisplayName("remove particular char from a string")
    void removeCharsTest() {
        assertEquals("stdent", removeChars("studuuenuut", 'u'));
    }
    @Test
    void removeExtraSpacesTest() {
        assertEquals("abc ed ef", removeExtraSpaces("   abc  ed   ef  "));
    }
}