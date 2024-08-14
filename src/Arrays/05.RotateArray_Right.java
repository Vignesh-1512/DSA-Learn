https://leetcode.com/problems/rotate-array/description/

class Solution {
    public void reverse(int[]arr, int st, int ed)
    {
        while(st<=ed)
        {
            int temp = arr[st];
            arr[st]=arr[ed];
            arr[ed]=temp;
            st++; ed--;
        }
    }
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        d= d%n;
        if (d == 0)
            return;

        reverse(arr,n-d,n-1);
        reverse(arr,0,n-d-1);
        reverse(arr,0,n-1);
    }
}