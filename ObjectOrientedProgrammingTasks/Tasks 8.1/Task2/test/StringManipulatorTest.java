import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private final StringManipulator manipulator = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", manipulator.concatenate("Hello", "World"));
        assertEquals("Java", manipulator.concatenate("Ja", "va"));
        assertEquals("nullTest", manipulator.concatenate(null, "Test")); // null concatenates as "null"
    }

    @Test
    void testFindLength() {
        assertEquals(5, manipulator.findLength("Hello"));
        assertEquals(0, manipulator.findLength(""));
        assertEquals(0, manipulator.findLength(null)); // defined behavior for null
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("hello"));
        assertEquals("", manipulator.convertToUpperCase(""));
        assertNull(manipulator.convertToUpperCase(null));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("world", manipulator.convertToLowerCase("WORLD"));
        assertEquals("", manipulator.convertToLowerCase(""));
        assertNull(manipulator.convertToLowerCase(null));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(manipulator.containsSubstring("HelloWorld", "World"));
        assertFalse(manipulator.containsSubstring("HelloWorld", "world")); // case-sensitive
        assertFalse(manipulator.containsSubstring(null, "test"));
        assertFalse(manipulator.containsSubstring("Hello", null));
    }
}
