https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int len=0;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                long sum=0;
                for(int K=i;K<=j;K++){
                    sum+=a[K];
                }
                if(sum==k){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
 */
//Method-2: Brutte:
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int len=0;
        for(int i=0;i<a.length;i++){
            long sum=0;
            for(int j=i;j<a.length;j++){


                sum+=a[j];

                if(sum==k){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
 */
// Hash Map method:

import java.util.*;
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int n=a.length;
        Map<Long,Integer> preSumMap=new HashMap<>();
        long sum=0;
        int maxLen=0;

        for(int i=0;i<n;i++){
            sum+=a[i];

            if(sum==k){
                maxLen=Math.max(maxLen, i+1);
            }

            long rem=sum-k;

            if(preSumMap.containsKey(rem)){
                int len=i-preSumMap.get(rem);
                maxLen=Math.max(maxLen,len);
            }

            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum,i);
            }
        }
        return maxLen;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
 */

// This will work for zeros and positive elements in an array

import java.util.*;
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int n=a.length;
        int left=0,right=0;
        long sum=a[0];
        int maxLen=0;
        while(right<n){
            while(left<=right && sum>k){
                sum -=a[left];
                left++;
            }

            if(sum==k){
                maxLen=Math.max(maxLen, right-left+1);
            }

            right++;
            if(right<n){sum+=a[right];}
        }
        return maxLen;
    }
}