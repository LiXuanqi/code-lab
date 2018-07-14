import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static algorithm.Strings.removeChars;
import static algorithm.Strings.removeExtraSpaces;
import static algorithm.Strings.removeDuplication;
import static algorithm.Strings.removeDuplicationRepeatedlyWithStack;
import static algorithm.Strings.removeDuplicationRepeatedlyWithTwoPointers;

class StringsTests {
    @Test
    void removeCharsTest() {
        assertEquals("stdent", removeChars("studuuenuut", 'u'));
    }
    @Test
    void removeExtraSpacesTest() {
        assertEquals("abc ed ef", removeExtraSpaces("   abc  ed   ef  "));
    }
    @Test
    void removeDuplicationTest() {
        assertEquals("ab c", removeDuplication("aabb  cc"));
    }
    @Test
    void removeDuplicationRepeatedlyWithStackTest() {
        assertEquals("z", removeDuplicationRepeatedlyWithStack("abbbbaz"));
    }
    @Test
    void removeDuplicationRepeatedlyWithTwoPointersTest() {
        assertEquals("z", removeDuplicationRepeatedlyWithTwoPointers("abbbbbaaz"));
    }
}