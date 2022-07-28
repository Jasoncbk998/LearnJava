import javax.crypto.Cipher;

public class 合并两个有序数组_88 {
    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 很骚
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }
}
