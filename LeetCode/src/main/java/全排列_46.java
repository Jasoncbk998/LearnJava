import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    //https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        ArrayList<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public static void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if(depth==len){
            res.add(path);
            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                List<Integer> newPath = new ArrayList<>();
                newPath.add(nums[i]);
                boolean[] newUsed = new boolean[len];
                System.arraycopy(used,0,newUsed,0,len);
                newUsed[i]=true;
                dfs(nums,len,depth+1,newPath,newUsed,res);
            }
        }


    }
}
