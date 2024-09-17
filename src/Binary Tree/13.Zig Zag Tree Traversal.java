https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

class Node
{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class GFG2
{
    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            GFG g = new GFG();

            ArrayList<Integer> res = g.zigZagTraversal(root) ;
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System. out. println();

            t--;

        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> ans=new ArrayList<>();

        if(root==null) return ans;

        // Queue to perform level order traversal
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        // Flag to determine the direction of traversal (left to right or right to left)
        boolean flag=true;

        // Continue traversal until the queue is empty
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();

            ArrayList<Integer> row=new ArrayList<>();

            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                Node node = q.poll();

                // Add the node's data based on the current traversal direction
                if (flag) {
                    row.add(node.data);
                } else {
                    row.add(0, node.data);  // Add at the beginning to reverse the order
                }

                // Enqueue the left and right children if they exist
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // Switch the traversal direction for the next level
            flag = !flag;

            // Add the current level's values to the result list
            ans.addAll(row);
        }

        // Return the final result of zigzag level order traversal
        return ans;
    }
}