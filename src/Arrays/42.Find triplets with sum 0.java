https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

//{ Driver Code Starts
import java.util.*;
class Triplets{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Solution g=new Solution();
            if(g.findTriplets(a,n))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(arr[i]+arr[j]+arr[k]==0) return true;
                }
            }
        }
        return false;
    }
}


//

class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Iterate over the array and apply the two-pointer technique
        for (int i = 0; i < n - 2; i++) {
            // Use two pointers to find a pair whose sum is equal to -arr[i]
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    return true; // Triplet found
                } else if (sum < 0) {
                    left++;  // If the sum is too small, increase the left pointer
                } else {
                    right--; // If the sum is too large, decrease the right pointer
                }
            }
        }

        // If no triplet with zero sum is found, return false
        return false;
    }
}