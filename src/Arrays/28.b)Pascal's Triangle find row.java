https://leetcode.com/problems/pascals-triangle-ii/

//Formula : Current element = prevElement * (rowNumber - colIndex) / colIndex

class Solution {
    public static int nCr(int n, int r)
    {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public List<Integer> getRow(int rowIndex) {
        int row = rowIndex+1; //0-Based Index
        List<Integer> tempLst = new ArrayList<>();
        for (int col = 1; col <= row; col++)
        {
            tempLst.add(nCr(row - 1, col - 1));
        }
        return tempLst;
    }
}