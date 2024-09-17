https://www.naukri.com/code360/problems/path-in-a-tree_3843990?leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*;
/*
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;

        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        solve(root, x, ans);
        return ans;
    }

    public static boolean solve(TreeNode root, int x, ArrayList<Integer> ans)
    {
        if(root==null) return false;
        ans.add(root.data);
        if(root.data==x) return true;
        if(solve(root.left,x, ans)|| solve(root.right,x, ans))
            return true;
        ans.remove(ans.size()-1);
        return false;
    }
}