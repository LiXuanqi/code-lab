package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    /**
     * Remove some particular chars from a string.
     *
     * @param str        "student"
     * @param deleteChar 'u'
     * @return           "stdent"
     */
    public static String removeChars(String str, char deleteChar) {
        if (str == null) {
            return "";
        }
        char[] input = str.toCharArray(); // String => char[]
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (input[fast] != deleteChar) {
                input[slow++] = input[fast];
            }
            fast++;
        }
        String result = new String(input, 0, slow); // char[] => String
        return result;
    }

    /**
     * Remove all leading/trailing and duplicate empty spaces(only leave one empty space if duplicated
     * spaces happen) from input string.
     *
     * @param str "_ _ _ abc _ _ ed _ _ ef _ _"
     * @return    "abc_ed_ef"
     */
    public static String removeExtraSpaces(String str) {
        char[] input = str.toCharArray();
        int slow = 0;
        int fast = 0;
        int wordCount = 0;
        while (fast < input.length) {
            while (fast < input.length && input[fast] == ' ') {
                fast++;
            }
            if (fast < input.length && wordCount > 0) {
                input[slow++] = ' ';
            }
            while (fast < input.length && input[fast] != ' ') {
                input[slow++] = input[fast++];
            }
            wordCount++;
        }
        String result = new String(input, 0, slow);
        return result;
    }

    /**
     * Remove duplicated and adjacent letters(leave only one letter in each duplicated section) in a string.
     *
     * @param str "a a b b _ _ c c"
     * @return    "ab_c"
     */
    public static String removeDuplication(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] input = str.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < input.length) {
            if (input[fast] != input[slow - 1]) {
                input[slow++] = input[fast];
            }
            fast++;
        }
        return new String(input, 0, slow);
    }
    /**
     * Char de-duplication adjacent letters repeatedly
     *
     * @param str "abbbbaz" => "aaz" => "z"
     * @return    "z"
     */
    public static String removeDuplicationRepeatedlyWithStack(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        List<Character> stack = new ArrayList<Character>();
        int i = 0;
        while (i < str.length()) {
            char pivot = str.charAt(i);
            if (stack.size() > 0 && str.charAt(i) == stack.get(stack.size() - 1)) {
                while (i < str.length() && str.charAt(i) == pivot) {
                    i++;
                }
                stack.remove(stack.size() - 1);
            } else {
                stack.add(str.charAt(i));
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
