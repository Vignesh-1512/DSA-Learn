https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
// Initial Template for Java

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

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Tree g = new Tree();
            root = g.deleteNode(root, x);
            printInorder(root);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Tree {
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int key) {
        // code here.
        if(root==null)  return null;

        if(root.data<key)
            root.right = deleteNode(root.right,key);
        else if(root.data>key)
            root.left = deleteNode(root.left,key);
        else //this is the node to be deleted
        {
            //leaf node
            if(root.left==null && root.right==null)
                return null;
                //has only left child
            else if(root.left!=null && root.right==null)
                return root.left;
                //has only left child
            else if(root.left==null && root.right!=null)
                return root.right;
                //has both child
            else
            {
                Node rightChild = root.right;
                Node lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                return root.left;
            }
        }
        return root;
    }
    public static Node findLastRight(Node root)
    {
        if(root.right==null)
            return root;

        return findLastRight(root.right);
    }
}