https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        solve(0, s, res, path);
        return res;
    }

    public void solve(int idx, String s, List<List<String>> res,List<String> path)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList< >(path));
            return;
        }

        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(idx, s, i))
            {
                path.add(s.substring(idx, i+1));
                solve(i+1, s, res, path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(int st, String s, int ed)
    {
        while(st<=ed)
        {
            if(s.charAt(st++)!=s.charAt(ed--)) return false;
        }
        return true;
    }
}