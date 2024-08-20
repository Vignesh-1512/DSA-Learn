https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_s

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int cnt=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++){
                //calculate the sum of subarray[i...j]
                int sum=0;
                for(int K=i;K<=j;K++)
                {
                    sum+=Arr[K];
                }
                //Increasing the cnt if sum==k
                if(sum==k)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Method-2:

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int cnt=0;
        for(int i=0;i<N;i++)
        {
            //calculate the sum of subarray[i...j]
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=Arr[j];

                //Increasing the cnt if sum==k
                if(sum==k)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Method-3:

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        Map<Integer,Integer> mpp=new HashMap<>();
        int preSum=0;
        int cnt=0;

        mpp.put(0,1);
        for(int i=0;i<N;i++)
        {
            // add current element to prefix Sum:
            preSum+=Arr[i];

            // Calculate x-k:
            int remove=preSum-k;

            // Add the number of subarrays to be removed:
            cnt+=mpp.getOrDefault(remove,0);

            // Update the count of prefix sum
            // in the map.

            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}