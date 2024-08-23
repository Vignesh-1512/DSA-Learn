https://leetcode.com/problems/word-subsets/description/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<>();
        int[] target=new int[26];

        for(String b:words2)
        {
            int[] temp=new int[26];
            for(char ch : b.toCharArray())
            {
                temp[ch -'a']++;
                target[ch-'a']=Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }

        for(String a: words1)
        {
            int[] arr=new int[26];
            for(char ch: a.toCharArray())
            {
                arr[ch-'a']++;
            }
            if(check(arr,  target))
            {
                ans.add(a);
            }
        }
        return ans;

    }
    public boolean check(int[] arr, int[] target)
    {
        for(int i=0;i<26;i++)
        {
            if(target[i]>arr[i])
                return false;
        }
        return true;
    }


}