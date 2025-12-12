package com.refresh.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    // ---- reverseInPlace(char[]) tests ----

    @Test
    void reverseInPlace_shouldReverseHello() {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};

        ReverseString.reverseInPlace(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseInPlace_shouldReverseHannah() {
        char[] input = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expected = {'h', 'a', 'n', 'n', 'a', 'H'};

        ReverseString.reverseInPlace(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseInPlace_shouldHandleSingleChar() {
        char[] input = {'a'};
        char[] expected = {'a'};

        ReverseString.reverseInPlace(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseInPlace_shouldHandleEmptyArray() {
        char[] input = {};
        char[] expected = {};

        ReverseString.reverseInPlace(input);

        assertArrayEquals(expected, input);
    }

    // ---- reverseAscii(String) tests ----

    @Test
    void reverseAscii_shouldReverseWord() {
        String input = "hey";
        String expected = "yeh";

        String actual = ReverseString.reverseAscii(input);

        assertEquals(expected, actual);
    }

    @Test
    void reverseAscii_shouldHandleEmptyString() {
        assertEquals("", ReverseString.reverseAscii(""));
    }

    @Test
    void reverseAscii_shouldReturnNullWhenInputNull() {
        assertNull(ReverseString.reverseAscii(null));
    }

    // ---- Unicode behavior tests ----

    @Test
    void reverseUnicode_shouldReverseEmojiCorrectly() {
        String input = "A😀B";
        String expected = "B😀A";

        String actual = ReverseString.reverseUnicode(input);

        assertEquals(expected, actual);
    }

    @Test
    void reverseAscii_shouldNotBeUnicodeSafeForEmoji() {
        // Demonstrates why char-based reversal breaks surrogate pairs.
        String input = "A😀B";
        String asciiReversed = ReverseString.reverseAscii(input);

        assertNotEquals("B😀A", asciiReversed); // likely broken
        assertEquals("B", ReverseString.reverseUnicode("B")); // sanity check
    }
}
