package com.refresh.algorithms.strings;

public final class ReverseString {

    private ReverseString() {
    }

    /**
     * In-place reverse for char[] (O(1) extra memory).
     */
    public static void reverseInPlace(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;

        }
    }

    /**
     * Reverse a String assuming simple char-based reversal (ASCII-safe, not emoji-safe).
     */
    public static String reverseAscii(String input) {
        if (input == null) return null;

        StringBuilder result = new StringBuilder(input.length());
        char[] chars = input.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return result.toString();
    }

    /**
     * Unicode-safe reverse using code points (handles emojis & surrogate pairs correctly).
     */
    public static String reverseUnicode(String input) {
        if (input == null) return null;

        int[] cps = input.codePoints().toArray();
        for (int l = 0, r = cps.length - 1; l < r; l++, r--) {
            int tmp = cps[l];
            cps[l] = cps[r];
            cps[r] = tmp;
        }
        return new String(cps, 0, cps.length);
        //new String(
        //    cps,        // source array of Unicode characters
        //    0,          // start from index 0
        //    cps.length  // take all elements
        //);
    }
}
