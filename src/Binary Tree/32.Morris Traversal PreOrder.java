/*
    Following is the TreeNode class structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };
*/

import java.util.*;

public class Solution {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> preorder = new ArrayList<>();

        TreeNode cur = root;
        while(cur!=null)
        {
            if(cur.left==null)
            {
                preorder.add(cur.data);
                cur=cur.right;
            }
            else{
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child is NULL, establish a temporary link and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                } else {
                    // If the predecessor's right child is already linked, remove the link,
                    // add current node to inorder list, and move to the right child
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}