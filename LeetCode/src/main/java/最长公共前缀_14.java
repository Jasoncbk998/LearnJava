public class 最长公共前缀_14 {
    /**
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 第一个元素的长度
        int length = strs[0].length();
        // 元素个数
        int count = strs.length;
        // 外层循环次数
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                // 第j个元素的第i个字符与第一个元素的第i个字符进行比较
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
