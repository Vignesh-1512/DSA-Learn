https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();

        }
        out.close();
    }
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans=new ArrayList<>();
        char[] c=S.toCharArray();
        boolean[] freq=new boolean[c.length];
        StringBuilder t=new StringBuilder();
        solve(ans, c, freq, t);
        Collections.sort(ans);
        return ans;
    }

    public void solve(List<String> ans, char[] c, boolean[] freq, StringBuilder t)
    {
        if(c.length==t.length())
        {
            String res=t.toString();
            if(!ans.contains(res))
            {
                ans.add(res);
                return;
            }
        }

        for(int i=0;i<c.length;i++)
        {
            if(!freq[i])
            {
                t.append(c[i]);
                freq[i]=true;
                solve(ans, c, freq, t);
                t.deleteCharAt(t.length()-1);
                freq[i]=false;
            }
        }
    }
}