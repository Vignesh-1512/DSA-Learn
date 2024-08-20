https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    markRow(matrix,n,m,i);
                    markCol(matrix,n,m,j);
                }
            }
        }
        //finally mark all -1's to zero
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==-1)
                    matrix[i][j]=0;
            }
        }
    }
    // set all non-zero elements as -1 in the row i:
    static void markRow(int[][] matrix, int n, int m, int i)
    {
        for(int j=0;j<m;j++)
        {
            if(matrix[i][j] !=0)
            {
                matrix[i][j]=-1;
            }
        }
    }
    // set all non-zero elements as -1 in the col j:
    static void markCol(int[][] matrix, int n, int m, int j)
    {
        for(int i=0;i<n;i++)
        {
            if(matrix[i][j] !=0)
            {
                matrix[i][j]=-1;
            }
        }
    }
}

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Method-2:

class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row[]=new int[n];
        int col[]=new int[m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(row[i]==1||col[j]==1)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}


/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */



