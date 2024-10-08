https://www.geeksforgeeks.org/problems/count-number-of-nodes-in-a-binary-tree/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }
            Node root = new Node(v[0]);
            int cnt = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node cur = null;
            for (int i = 1; i < n; i++) {
                Node node = new Node(v[i]);
                if (cnt == 0) {
                    cur = q.peek();
                    q.poll();
                }
                if (cnt == 0) {
                    cnt++;
                    cur.left = node;

                } else {
                    cnt = 0;
                    cur.right = node;
                }
                if (v[i] >= 0) {
                    q.add(node);
                }
            }

            Solution obj = new Solution();
            int ans = obj.countNodes(root);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    public static int countNodes(Node root) {
        // Code here
        if(root ==null ) return 0;

        int lh=findHeightLeft(root);
        int rh=findHeightRight(root);

        if(lh==rh) return ((2<<lh)-1);

        else return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static int findHeightLeft(Node root)
    {
        int cnt=0;
        while(root.left!=null)
        {
            cnt++;
            root=root.left;
        }
        return cnt;
    }

    public static int findHeightRight(Node root)
    {
        int cnt=0;
        while(root.right!=null)
        {
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}

//Method-2:

// User function Template for Java

class Solution {

    public static int countNodes(Node root) {
        // Code here
        if(root ==null ) return 0;

        int[] cnt={0};

        inOrder(root,cnt);
        return cnt[0];
    }

    public static void inOrder(Node root, int[] cnt)
    {
        if(root == null) return;

        cnt[0]++;

        inOrder(root.left,cnt);
        inOrder(root.right,cnt);
    }
}