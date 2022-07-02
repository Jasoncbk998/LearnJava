import java.util.HashMap;
import java.util.Map;

public class 两数之和_01 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3}, 4);
        System.out.println(tools.printArray(ints));
    }


    public static  int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{maps.get(target - nums[i]), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }

}

