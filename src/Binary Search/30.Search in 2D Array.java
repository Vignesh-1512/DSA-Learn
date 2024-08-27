https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

//Method-2:


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]<=target && target<= matrix[i][m-1])
            {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] matrix, int target)
    {
        int n=matrix.length;
        int low=0;
        int high=n-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(matrix[mid]==target) return true;

            else if(matrix[mid]>target) high=mid-1;

            else low=mid+1;
        }
        return false;
    }
}

//Method-3:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int low=0, high=n*m-1;
        while(low<=high){
            int mid=(low+high)/2;

            int row=mid/m, col=mid%m;

            if(matrix[row][col]==target) return true;

            else if(matrix[row][col] > target) high=mid-1;

            else low=mid+1;
        }
        return false;
    }
}