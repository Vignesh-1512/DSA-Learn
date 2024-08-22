https://www.geeksforgeeks.org/problems/anagram-1587115620/1

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {

        // Your code here
        if(a.length()!=b.length()) return false;

        HashMap<Character,Integer> map= new HashMap<>();

        for(int i=0;i<a.length();i++)
        {
            char ch=a.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<b.length();i++)
        {
            char ch=b.charAt(i);
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)-1);
            else
                return false;

            if(map.get(ch)==0) map.remove(ch);
        }

        if(map.size()==0) return true;
        return false;
    }
}