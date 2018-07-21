package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] input = str.toCharArray();
        int slow = 0;
        int fast = 0;
        int count = 0;
        while (fast < input.length) {
            if (input[fast] == ' ') {
                fast++;
                continue;
            }
            if (count != 0) {
                input[slow++] = ' ';
            }
            while (fast < input.length && input[fast] != ' ') {
                input[slow++] = input[fast++];
            }
            count++;
        }
        return new String(input, 0, slow);
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
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] input = str.toCharArray();
        List<Character> stack = new ArrayList<>();
        int i = 0;
        while (i < input.length) {
            if (i < input.length && stack.size() != 0 && input[i] == stack.get(stack.size() - 1)) {
                char pivot = input[i];
                while (i < input.length && input[i] == pivot) {
                    i++;
                }
                stack.remove(stack.size() - 1);
            } else {
                stack.add(input[i++]);
            }
        }
        char[] result = new char[stack.size()];
        for (int j = 0; j < stack.size(); j++) {
          result[j] = stack.get(j);
        }
        return new String(result);
    }
    /**
     * Char de-duplication adjacent letters repeatedly
     *
     * @param str "abbbbaz" => "aaz" => "z"
     * @return    "z"
     */
    public static String removeDuplicationRepeatedlyWithTwoPointers(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] input = str.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < input.length) {
            if (slow == 0 || input[fast] != input[slow - 1]) {
                input[slow++] = input[fast++];
            } else {
                while (fast < input.length && input[fast] == input[slow - 1]) {
                    fast++;
                }
                slow--;
            }
        }
        return new String(input, 0, slow);
    }
    /**
     * Reverse words one by one.
     *
     * @param str "I love yahoo"
     * @return    "yahoo love I"
     */
    public static String reverseWord(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] input = str.toCharArray();
        reverse(input, 0, input.length - 1);
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (fast == input.length - 1) {
                reverse(input, slow, fast);
                break;
            }
            if (input[fast] != ' ') {
                fast++;
            } else {
                reverse(input, slow, fast - 1);
                fast += 1;
                slow = fast;
            }
        }
        return new String(input);
    }
    private static void reverse(char[] str, int start, int end) {
        while (start <= end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
    /**
     * Shift the whole stirng to the right-hand side by k positions.
     *
     * @param str "abcdef"
     * @param k 2
     * @return "efabcd"
     */
    public static String shiftKPositions(String str, int k) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] input = str.toCharArray();
        reverse(input, 0, input.length - 1);
        reverse(input, 0, k - 1);
        reverse(input, k, input.length -1);
        return new String(input);
    }
    /**
     *  Replace characters in the string.
     *
     * @param str "student"
     * @param target "den" (3)
     * @param alternate "XX" (2)
     * @return "stuXXt"
     */
    public static String replaceFromLongToShort(String str, String target, String alternate) {
        int slow = 0;
        int fast= 0;
        char[] input = str.toCharArray();
        while (fast < input.length) {
            if (input[fast] == target.charAt(0)) {
                int pivot = 0;
                while (fast < input.length && pivot < target.length() && input[fast] == target.charAt(pivot)) {
                    fast++;
                    pivot++;
                }
                for (int i = 0; i < alternate.length(); i++) {
                    input[slow++] = alternate.charAt(i);
                }
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }
    /**
     * Replace characters in the string.
     *
     * @param str "http://test_replace_.com"
     * @param target "_" (1)
     * @param alternate "20%" (2)
     * @return "http://test20%replace20%.com"
     */
    public static String replaceFromShortToLong(String str, String target, String alternate) {
        int count = 0;
        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (target.equals(str.substring(i, i + target.length()))) {
                count++;
            }
        }
        char [] sa = str.toCharArray();
        char[] input = Arrays.copyOf(sa, count * (alternate.length() - target.length()) + sa.length);
        int slow = input.length - 1;
        int fast = sa.length - 1;
        while (fast >= 0) {
            if (input[fast] == target.charAt(target.length() - 1)) {
                int pivot = target.length() - 1;
                while (fast >= 0 && pivot >= 0 && input[fast] == target.charAt(pivot)) {
                    fast--;
                    pivot--;
                }
                for (int i = alternate.length() - 1; i >= 0; i--) {
                    input[slow--] = alternate.charAt(i);
                }
            } else {
                input[slow--] = input[fast--];
            }
        }
        return new String(input);
    }

    /**
     * Shuffling String.
     *
     * @param str "ABCD1234"
     * @return "A1B2C3D4"
     */
//    public static String shuffling(String str) {
//
//    }

    /**
     * Shuffling String reversely.
     *
     * @param str "A1B2C3D4"
     * @return "ABCD1234"
     */
//    public static String reverseShuffling(String str) {
//
//    }

    /**
     * Encoding the length of String.
     * @param str "aaaabccaaaaa"
     * @return "a4b1c2a5"
     */
//    public static String lengthEncoding(String str) {
//
//    }
}
