https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;

        // Recursively flatten the rest of the linked list
        Node mergedHead = flatten(root.next);
        root = merge(root, mergedHead);
        return root;
    }

    Node merge(Node list1, Node list2)
    {
        Node dNode=new Node(-1);
        Node res=dNode;

        while(list1!=null && list2!=null)
        {
            if(list1.data<list2.data)
            {
                res.bottom=list1;
                res=list1;
                list1=list1.bottom;
            }
            else
            {
                res.bottom=list2;
                res=list2;
                list2=list2.bottom;
            }
            res.next=null;
        }
        if(list1!=null) res.bottom=list1;
        else res.bottom=list2;

        // Break the last node's link to prevent cycles
        if (dNode.bottom != null) {
            dNode.bottom.next = null;
        }

        return dNode.bottom;
    }
}


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        }
        sc.close();
    }
}

// } Driver Code Ends