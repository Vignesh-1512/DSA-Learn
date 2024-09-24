https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int a;
            a = Integer.parseInt(br.readLine());


            int b;
            b = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.gcd(a, b);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(b==0) return a;
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}

//METHOD 1:

class Solution {
    public static int gcd(int a, int b) {
        int res = Math.min(a,b);
        while(res>0)
        {
            if(a%res==0 && b%res==0)
                break;
            res--;
        }
        return res;
    }
}

//METHOD 2 : Euclidean algorithm for GCD of two numbers:
// The idea of this algorithm is, the GCD of two numbers doesn’t change
// if the smaller number is subtracted from the bigger number.
// This is the Euclidean algorithm by subtraction.


class Solution {
    public static int gcd(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        if(a==b) return a;

        if(a>b)  return gcd(a-b,b);
        else return gcd(a,b-a);
    }
}

//METHOD 3: Optimization using division

class Solution {
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}