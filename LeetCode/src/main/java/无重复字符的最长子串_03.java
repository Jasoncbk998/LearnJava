import java.util.HashMap;

public class 无重复字符的最长子串_03 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // key=元素
            // value=索引
            map.put(s.charAt(i), i);
            // i+1 是当前长度
            // 减去left重复元素的长度
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ababa";
        int i = lengthOfLongestSubstring(s);

    }
}
