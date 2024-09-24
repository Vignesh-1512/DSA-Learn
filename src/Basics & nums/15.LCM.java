
class Solution {
    public static int gcd(int a, int b) {
        int res = Math.max(a,b);
        while(true)
        {
            if(res%a==0 && res%b==0)
                break;
            res++;
        }
        return res;
    }
}


//Euclidean Algo

    static int GCD(int a, int b)
    {
        if (b == 0)
            return a;

        return GCD(b, a % b);
    }

    // Function to find the LCM
    static int LCM(int a, int b)
    {
        return (a * b) / GCD(a, b);
    }