https://www.naukri.com/code360/problems/children-sum-property_8357239?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
 public int data;
 public Node left;
 public Node right;

 Node()
 {
 this.data = 0;
 this.left = null;
 this.right = null;
 }

 Node(int data)
 {
 this.data = data;
 this.left = null;
 this.right = null;
 }

 Node(int data, Node left, Node right)
 {
 this.data = data;
 this.left = left;
 this.right = right;
 }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        if(root==null) return true;
        if (root.left == null && root.right == null) return true;
        int child = 0;

        // Sum the values of the left and right children
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;
        return (root.data == child && isParentSum(root.left) && isParentSum(root.right));
    }

    public static void solve(Node root)
    {
        if(root == null) return;

        int child=0;
        if(root.left!=null){
            child+=root.left.data;
        }
        if(root.right !=null)
        {
            child+=root.right.data;
        }

        if(child>=root.data)
        {
            root.data=child;
        }
        else{
            if(root.left!=null)
            {
                root.left.data=root.data;
            }
            if(root.right!=null)
            {
                root.right.data=root.data;
            }
        }

        solve(root.left);
        solve(root.right);

        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = tot;
        }
    }
}