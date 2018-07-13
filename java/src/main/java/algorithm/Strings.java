package algorithm;

public class Strings {
    /**
     * Remove some particular chars from a string.
     *
     * @param str "student"
     * @param deleteChar 'u'
     * @return  "stdent"
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
        System.out.println("Input: " + str + " delete: " + deleteChar);
        System.out.println("Output: " + result);
        return result;
    }

    /**
     * Remove all leading/trailing and duplicate empty spaces(only leave one empty space if duplicated
     * spaces happen) from input string.
     *
     * @param str "_ _ _ abc _ _ ed _ _ ef _ _"
     * @return "abc_ed_ef"
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
        System.out.println("Input: " + str);
        System.out.println("Output: " + result);
        return result;
    }
}
