import java.util.logging.Level;

public class 最长回文子串_05 {
    /**
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int left = 0;
        int pl = 0;
        int pr = 0;
        int right = -1;
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        // 不断向右移动回文边界
        while (left < length) {
            while (right + 1 < length && bytes[left] == bytes[right + 1]) {
                right++;
            }
            while (left - 1 >= 0 && right + 1 < length && bytes[right + 1] == bytes[left - 1]) {
                left--;
                right++;
            }
            if (right - left > pr - pl) {
                pr = right;
                pl = left;
            }
            left = (left + right) / 2 + 1;
            right = left;
        }
        return s.substring(pl, pr + 1);
    }


    public static void main(String[] args) {
        String s = "aaabccbadddd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
