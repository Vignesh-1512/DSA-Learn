https://leetcode.com/problems/merge-intervals/?envType=problem-list-v2&envId=array

class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        // Sort intervals based on the starting point of each interval
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // Create a list to store merged intervals
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int st=intervals[i][0];
            int ed=intervals[i][1];
            if(ans.isEmpty() || st>ans.get(ans.size()-1)[1])
            {
                ans.add(new int[]{st, ed});
            }
            else
            {
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],ed);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}