https://www.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> result = new ArrayList<>();
        // Find the target node and gather all nodes at distance k from it
        findKDistanceNodes(root, target, k, result);
        // Sort the result as required
        Collections.sort(result);

        return result;
    }
    private static int findKDistanceNodes(Node root, int target, int k, ArrayList<Integer> result)
    {
        // Base case
        if (root == null) {
            return -1;
        }

        // If the current node is the target node
        if (root.data == target) {
            collectSubtreeNodesAtDistance(root, k, result);
            return 0;
        }

        // Check if the target is in the left subtree
        int leftDistance = findKDistanceNodes(root.left, target, k, result);
        if (leftDistance != -1) {
            // If the current node is at distance k from target
            if (leftDistance + 1 == k) {
                result.add(root.data);
            } else {
                // Otherwise, find nodes in the right subtree at the required distance
                collectSubtreeNodesAtDistance(root.right, k - leftDistance - 2, result);
            }
            return leftDistance + 1;
        }

        // Check if the target is in the right subtree
        int rightDistance = findKDistanceNodes(root.right, target, k, result);
        if (rightDistance != -1) {
            // If the current node is at distance k from target
            if (rightDistance + 1 == k) {
                result.add(root.data);
            } else {
                // Otherwise, find nodes in the left subtree at the required distance
                collectSubtreeNodesAtDistance(root.left, k - rightDistance - 2, result);
            }
            return rightDistance + 1;
        }

        return -1; // Target node not found in this subtree
    }

    // Collect all nodes at exactly distance k from the given node in the subtree
    private static void collectSubtreeNodesAtDistance(Node root, int k, ArrayList<Integer> result)
    {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            result.add(root.data);
            return;
        }

        collectSubtreeNodesAtDistance(root.left, k - 1, result);
        collectSubtreeNodesAtDistance(root.right, k - 1, result);
    }
};