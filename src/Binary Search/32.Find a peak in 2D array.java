https://leetcode.com/problems/find-a-peak-element-ii/submissions/1369963218/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int n=mat.length;
        int m=mat[0].length;
        int low=0, high=m-1;
        while(low<=high)
        {
            int mid=(low+high)/2; //indicates the coloumn in 2D array
            int row=findMax(mat, n , mid);

            int left=mid-1>=0 ? mat[row][mid-1] : -1;
            int right=mid+1< m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && right<mat[row][mid])
            {
                ans[0]=row; ans[1]=mid;
                return ans;
            }
            else if(mat[row][mid]<left) high=mid-1;
            else low=mid+1;
        }
        return ans;
    }

    public int findMax(int[][] mat, int n, int col)
    {
        int ans = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++)
        {
            if(mat[i][col]>ans)
            {
                ans = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
}
