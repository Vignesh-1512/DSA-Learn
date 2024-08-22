https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/

class Solution {
    public String[] divideString(String s, int k, char fill) {

        int extra=0;
        if(s.length()%k !=0)
        {
            extra=s.length()%k;
            extra=k-extra;
        }

        for(int i=0;i<extra;i++)
        {
            s=s+fill;
        }

        String[] ans=new String[s.length()/k];
        int idx=0;
        for(int i=0;i<s.length();i+=k)
        {
            ans[idx]=s.substring(i,i+k);
            idx++;
        }
        return ans;
    }
}