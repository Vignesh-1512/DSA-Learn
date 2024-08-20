https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //int m=matrix[0].length;
        //create new matrix to store result
        int[][] ans=new int[n][n];

        //rotate the arry by 90 degree and store
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[j][n-1-i]=matrix[i][j];
            }
        }

        //copy the rotated result back to the original matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=ans[i][j];
            }
        }
    }
}


/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Meth0d-2:

class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        //Transpose
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<m; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //Reverse
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}