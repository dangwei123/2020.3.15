给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0) return 0;
        int tmp=1;
        grid[i][j]=0;
        return tmp+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
}

给定一个没有重复数字的序列，返回其所有可能的全排列。
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new LinkedList<>();
        List<Integer> row=new LinkedList<>();
        boolean[] flag=new boolean[nums.length];
        Arrays.fill(flag,false);
        permute(nums,row,flag);
        return res;
    }
    private void permute(int[] nums,List<Integer> row,boolean[] flag){
        if(row.size()==nums.length){
            res.add(new LinkedList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                row.add(nums[i]);
                flag[i]=true;
                permute(nums,row,flag);
                flag[i]=false;
                row.remove(row.size()-1);
            } 
        }
    }
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new LinkedList<>();
        List<Integer> row=new LinkedList<>();
        boolean[] flag=new boolean[nums.length];
        Arrays.fill(flag,false);
        permute(nums,row,0,flag);
        return res;
    }
    private void permute(int[] nums,List<Integer> row,int index,boolean[] flag){
        if(index==nums.length){
            res.add(new LinkedList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                row.add(nums[i]);
                flag[i]=true;
                permute(nums,row,index+1,flag);
                flag[i]=false;
                row.remove(row.size()-1);
            } 
        }
    }
}

