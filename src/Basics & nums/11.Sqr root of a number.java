https://www.geeksforgeeks.org/problems/square-root/1

class Solution {
    long floorSqrt(long n) {
        // Your code here
        int ans=(int) Math.sqrt(n);
        return ans;
    }
}


class Solution {
    long floorSqrt(long n) {
        // Your code here
        if (n < 2) return n;

        long low = 1; long high = n;
        while (low <= high)
        {
            long mid = (low + high) / 2;
            if (mid * mid == n)
                return mid;
            else if (mid * mid < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}