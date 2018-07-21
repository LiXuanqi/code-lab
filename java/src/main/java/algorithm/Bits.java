package algorithm;

public class Bits {
    /**
     * Given a number x, set x's k-th bit to 1
     *
     * @param num "xxxx Yxxx"
     * @param k 3
     * @return "xxxx 1xxx"
     */
    public static int setKthBitTo1(int num, int k) {
        return num | (1 << k);
    }

    /**
     * Given a number x, set x's k-th bit to 0
     * @param num "xxxx Yxxx"
     * @param k 3
     * @return "xxxx 0xxx"
     */
    public static int setKthBitTo0(int num, int k) {
        return num & ~(1 << k);
    }

    /**
     * Determine whether a number x is a power of 2 (x == 2 ^ n) n > 0
     *
     * @param num 4
     * @return true
     */
//    public static boolean isPowerOf2(int num) {
//
//    }
}
