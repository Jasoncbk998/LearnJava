import java.util.HashMap;

public class 最长递增子序列_300 {
    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 存储每一个位置的最大递增序列值
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            // 认为每个位置的元素最大递增序列数至少是1
            dp[i] = 1;
            // 循环截止到i,从0-i开始检查
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 最大递增序列值不断比较进行max求值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //寻找最大值
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tails = new int[len];
        int size = 0;
        // 枚举元素
        for (int num : nums) {
            int l = 0;
            int r = size;
            while (l < r) {
                int m = (r - l) / 2 + l;
                if (tails[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = num;
            if (l == size) {
                ++size;
            }
        }
        return size;
    }
}
