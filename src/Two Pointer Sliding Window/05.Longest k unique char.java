https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
        int l=0, r=0, ans=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r<n)
        {

            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            r++;
            while(map.size()>k)
            {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)   map.remove(s.charAt(l));
                l++;
            }
            if (map.size() == k) {
                ans = Math.max(ans, r - l); // r - l gives the length of the current valid substring
            }

        }
        return ans;
    }
}
//Brute
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
        int ans=-1;

        for(int i=0;i<n;i++)
        {
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++)
            {
                char c = s.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.size()==k)
                {
                    ans=Math.max(ans,j-i+1);
                }
                else if(map.size()>k)
                    break;
            }
        }
        return ans;
    }
}