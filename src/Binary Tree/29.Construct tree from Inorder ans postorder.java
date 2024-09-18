https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1

//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(n, inorder, postorder);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends




/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

class GfG {
    // Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int n, int in[], int post[]) {
        // Your code here
        if(in==null || post==null || in.length!=post.length) return null;

        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<in.length;i++)
        {
            hm.put(in[i],i);
        }
        return buildTree(in,0, in.length-1, post, 0, post.length-1, hm);
    }

    Node buildTree(int in[],int inS, int inE,
                   int post[], int postS, int postE,
                   HashMap<Integer, Integer> hm)
    {
        if(postS>postE || inS>inE)
        {
            return null;
        }
        Node root = new Node(post[postE]);
        int inRoot=hm.get(post[postE]);
        int numsLeft=inRoot-inS;
        root.left=buildTree(in, inS, inRoot-1, post, postS, postS+numsLeft-1, hm);
        root.right=buildTree(in, inRoot+1, inE, post, postS+numsLeft, postE-1, hm);

        return root;
    }
}
