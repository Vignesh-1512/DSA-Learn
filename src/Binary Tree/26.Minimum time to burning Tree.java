https://www.geeksforgeeks.org/problems/burning-tree/1

//{ Driver Code Starts
//Initial Template for Java


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
            if (i >= ip.length)
                break;

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
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;

    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/

    public static int minTime(Node root, int target)
    {
        // To store the minimum time to burn the whole tree
        int[] minTime = new int[1];
        minTime[0] = 0;

        // Find the target node and calculate the burn time
        findAndBurn(root, target, minTime);

        return minTime[0];
    }

    // Helper method to find the target node and calculate burn time
    private static int findAndBurn(Node root, int target, int[] minTime)
    {
        if (root == null) {
            return -1;
        }

        // If target node is found
        if (root.data == target) {
            // Start burning the subtree
            burnSubtree(root, 0, minTime);
            return 1;
        }

        // Recurse on the left subtree
        int leftDistance = findAndBurn(root.left, target, minTime);
        if (leftDistance != -1) {
            // Fire will spread to this node from the left subtree
            minTime[0] = Math.max(minTime[0], leftDistance);
            burnSubtree(root.right, leftDistance + 1, minTime);
            return leftDistance + 1;
        }

        // Recurse on the right subtree
        int rightDistance = findAndBurn(root.right, target, minTime);
        if (rightDistance != -1) {
            // Fire will spread to this node from the right subtree
            minTime[0] = Math.max(minTime[0], rightDistance);
            burnSubtree(root.left, rightDistance + 1, minTime);
            return rightDistance + 1;
        }

        // Target node not found in this subtree
        return -1;
    }

    // Burn the entire subtree from a given node, incrementing time as we go deeper
    private static void burnSubtree(Node root, int time, int[] minTime)
    {
        if (root == null) {
            return;
        }

        // Update the time it takes to burn this node
        minTime[0] = Math.max(minTime[0], time);

        // Burn the left and right subtrees
        burnSubtree(root.left, time + 1, minTime);
        burnSubtree(root.right, time + 1, minTime);
    }
}