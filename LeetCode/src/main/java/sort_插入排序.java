public class sort_插入排序 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        insertSort(nums, nums.length);
        for (int a : nums) {
            System.out.print(a + "\t");
        }
    }

    public static void insertSort(int[] a, int n) {
        int i, j, k;
        for (i = 1; i < n; i++) {
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    break;
                }
                if (j != i - 1) {
                    // 将比a[i]大的数据向后移
                    int temp = a[i];
                    for (k = i - 1; k > j; k--) {
                        a[k + 1] = a[k];
                        // 将a[i]放到正确的位置上
                        a[k + 1] = temp;
                    }
                }
            }
        }
    }
}
