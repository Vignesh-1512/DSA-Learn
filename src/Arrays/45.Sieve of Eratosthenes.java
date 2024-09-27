https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        ArrayList<Integer> List=new ArrayList<>();
        for(int i=2;i<=N;i++)
        {
            if(isPrime(i)==1)
                List.add(i);
        }
        return List;
    }

    static int isPrime(int N){
        // code here
        if(N<=1)    return 0;

        for(int i=2; i<=Math.sqrt(N); i++)
        {
            if(N%i==0)  return 0;
        }

        return 1;
    }
}