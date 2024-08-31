https://www.geeksforgeeks.org/problems/find-kth-permutation-0932/0

//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static String kthPermutation(int n,int k) {
        // code here
        // List of numbers to get indices from
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Build the Kth permutation using the recursive function
        return getPermutation(numbers, k);
    }

    public static String getPermutation(List<Integer> numbers, int k) {
        int n = numbers.size();
        if (n == 1) {
            return String.valueOf(numbers.get(0));
        }

        // Calculate the factorial of (n-1)
        int fact = factorial(n - 1);

        // Determine the first digit index
        int index = (k - 1) / fact;

        // Select the digit at that index
        String firstDigit = String.valueOf(numbers.get(index));

        // Remove the used digit from the list
        numbers.remove(index);

        // Recursive call for the remaining digits
        k = k - index * fact;
        return firstDigit + getPermutation(numbers, k);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

}



//{ Driver Code Starts.

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int[] a = IntArray.input(br, 2);

            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends