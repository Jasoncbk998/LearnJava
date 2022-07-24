import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_15 {
    /**
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * @param nums
     * @return
     */
    /**
     * 基本思想
     * 比如数组5个元素
     * 取出第一个元素,然后依次与2到4位元素依次做组合进行求和比较,相当于枚举出元素i=0的所有可能
     * 取出第二个元素,然后依次与3到4位元素依次做组合进行求和比较,相当于枚举出元素i=1的所有可能
     * ... ...
     * ...
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序
        // 固定i 然后i与 i+1,length-1 组合进行sum
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 因为已经对nums进行了排序
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // 等于0 ,进行add
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 因为当前区间求和为0,所以可以再次做一定优化
                    // 相同的元素可以省略比较
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}