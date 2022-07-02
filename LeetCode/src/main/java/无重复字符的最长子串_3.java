import java.util.HashMap;

public class 无重复字符的最长子串_3 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }
        int maxLenght = 0, left = 0;
        //  abcabcbb
        for (int i = 0; i < s.length(); i++) {
            int charLastIndex = index[s.charAt(i)];
            // 重复次数
            left = Math.max(left, charLastIndex + 1);
            // 0
            char chars = s.charAt(i);
            // 更新元素出现的索引位置 i
            index[s.charAt(i)] = i;
            // 0-0+1=1
            //比较大小
            maxLenght = Math.max(maxLenght, i - left + 1);
        }
        return maxLenght;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        String ss = "abbb";
        int i = lengthOfLongestSubstring(ss);
        System.out.println(i);
    }
}
