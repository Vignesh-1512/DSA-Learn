import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Pair{
    TreeNode node;
    int count;
    Pair(TreeNode node, int count)
    {
        this.node=node;
        this.count=count;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while(st.size()>0)
        {
            Pair curr = st.pop();
            if(curr.count==1)
            {
                pre.add(curr.node.data);
                curr.count++;
                st.push(curr);
                if(curr.node.left!=null)
                    st.push(new Pair(curr.node.left,1));
            }else if(curr.count==2)
            {
                in.add(curr.node.data);
                curr.count++;
                st.push(curr);
                if(curr.node.right!=null)
                    st.push(new Pair(curr.node.right,1));
            }else{
                post.add(curr.node.data);
            }
        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}