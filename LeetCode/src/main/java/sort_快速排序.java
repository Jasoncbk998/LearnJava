import java.util.Random;

public class sort_快速排序 {
    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        sortArray(nums);
    }
    public static  int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static  void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = nums[i];
            while (i < j) {
                while (i < j && nums[j] > x){
                    j--; // 从右向左找第一个小于x的数
                }
                if (i < j){
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < x){
                    i++; // 从左向右找第一个大于x的数
                }
                if (i < j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }
}
