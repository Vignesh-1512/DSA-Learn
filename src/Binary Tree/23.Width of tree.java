https://www.geeksforgeeks.org/problems/maximum-width-of-tree/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            int res = g.getMaxWidth(root);
            System.out.println(res);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Pair{
    Node node;
    int lineNo;
    Pair(Node node, int lineNo)
    {
        this.node = node;
        this.lineNo = lineNo;
    }
}
class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        if (root == null) return 0;

        int ans = 0;

        // Create a queue to perform level-order traversal
        Queue<Pair> q = new LinkedList<>();
        // Push the root node and its position (0) into the queue
        q.add(new Pair(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().lineNo;  // Get the position of the first node in the level

            int first = 0, last = 0;  // Initialize first and last positions for the level

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                Node node = current.node;
                int cur_id = current.lineNo - min;  // Normalize position to avoid overflow

                if (i == 0) {
                    first = cur_id;  // First node in the current level
                }

                if (i == size - 1) {
                    last = cur_id;  // Last node in the current level
                }

                // Enqueue the left child of the current node
                if (node.left != null) {
                    q.add(new Pair(node.left, cur_id * 2 + 1));
                }

                // Enqueue the right child of the current node
                if (node.right != null) {
                    q.add(new Pair(node.right, cur_id * 2 + 2));
                }
            }

            // Update the maximum width
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

}
