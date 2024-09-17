https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
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

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
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

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution
{
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> list= new ArrayList<>();
        if(node == null ) return list;

        list.add(node.data);

        leftBoundary(node.left,list);

        if(node.left==null && node.right==null)
        {}
        else
            bottomBoundary(node,list);

        rightBoundary(node.right,list);
        return list;
    }

    void leftBoundary(Node node, ArrayList<Integer> list)
    {
        if(node==null)  return;

        if(node.left==null && node.right==null)
        {}
        else list.add(node.data);

        if(node.left!=null) leftBoundary(node.left,list);
        else if(node.right!=null)   leftBoundary(node.right,list);
    }

    void bottomBoundary(Node node, ArrayList<Integer> list )
    {
        if(node==null)  return;

        if(node.left==null && node.right==null)
        {
            list.add(node.data);
        }
        bottomBoundary(node.left,list);
        bottomBoundary(node.right,list);
    }

    void rightBoundary(Node node, ArrayList<Integer> list)
    {
        if(node==null)  return;
        if(node.right!=null)   rightBoundary(node.right,list);
        else  if(node.left!=null) rightBoundary(node.left,list);

        if(node.left==null && node.right==null)
        {}
        else list.add(node.data);
    }
}
