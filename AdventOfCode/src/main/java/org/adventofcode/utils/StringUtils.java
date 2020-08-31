package org.adventofcode.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private StringUtils () {}

    /**
     * Count how many times each char is in the text
     * @param text
     * @param chars
     * @return list of counts corresponding to the chars
     */
    public static int[] countChars(String text, char[] chars) {
        int[] counts = new int[chars.length];

        for (char c : text.toCharArray()) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    counts[i]++;
                    break;
                }
            }
        }

        return counts;
    }

    /**
     * Checks if the string has a double letter, like aa, bb, cc, dd etc.
     * @param text
     * @return
     */
    public static boolean hasDoubleLetter (String text, int spacing) {
        for (int i = 0; i < text.length()-1-spacing; i++) {
            if (text.charAt(i) == text.charAt(i+1+spacing)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if ther are a non overlapping pair of specified length in the text. Ex for two: 'AZghtfAZfd'
     * @param text
     * @param length
     * @return
     */
    public static boolean nonOverlappingPair (String text, int length) {
        for (int i = 0; i < text.length()-length; i++) {
            String sequence = text.substring(i, i+length);
            int first = text.indexOf(sequence);
            int last = text.lastIndexOf(sequence);

            if (Math.abs(i - first) >= length || Math.abs(i - last) >= length) {
                return true;
            }
        }

        return false;
    }

    /**
     * Return length of spring after escaped sequences
     * @param text
     * @return
     */
    public static int memoryStringLength (String text) {
        String withoutDouble = text.replaceAll("\\\\\\\\", "");
        String withoutQuote = text.replaceAll("\\\\\"", "");
        String withoutAscii = text.replaceAll("\\\\x[a-f0-9]{2}", "");

        int doubleDiff = (text.length() - withoutDouble.length()) / 2;
        int quoteDiff = (text.length() - withoutQuote.length()) / 2;
        int asciiDiff = (text.length() - withoutAscii.length()) / 4;
        System.out.println(text + " => " + withoutDouble + " | " + withoutQuote + " | " + withoutAscii);
        System.out.println(text + " => " + doubleDiff + " | " + quoteDiff + " | " + asciiDiff);

        return text.length() - doubleDiff - quoteDiff - asciiDiff * 3;

        /*String withoutDouble = text.replaceAll("\\\\\\\\", "");
        String withoutQuote = text.replaceAll("\\\\\"", "");
        String withoutAscii = text.replaceAll("\\\\x[a-f0-9]{2}", "");
        System.out.println(text + " => " + withoutDouble + " | " + withoutQuote + " | " + withoutAscii);

        return text.replaceAll("\\\\\\\\", "A").replaceAll("\\\\\"", "B").replaceAll("\\\\x[a-f0-9]{2}", "C").length();*/
    }

    /**
     * Count how many similar chars there is from given index
     * @param text
     * @param index
     * @return
     */
    public static int countSimilarChars (String text, int index) {
        if (index >= text.length()) {
            return 0;
        }

        char cur = text.charAt(index);
        int count = 1;
        index++;
        while (index < text.length() && text.charAt(index) == cur) {
            count++;
            index++;
        }
        return count;
    }

    /**
     * If the string contains an increasing straight of 'length' letters. Example for length two: 'ab', 'bc', 'xy'.
     * @param text
     * @param length
     * @return
     */
    public static boolean containsIncreasingStraight (String text, int length) {
        if (length > text.length()) {
            return false;
        }

        for (int i = 0; i < text.length() - length; i++) {
            int count = 1;
            int prev = text.charAt(i);
            for (int j = 1; j < length; j++) {
                if (text.charAt(i+j) == prev + 1) {
                    count++;
                    prev++;
                }
            }

            if (count == length) {
                return true;
            }
        }

        return false;
    }


}
