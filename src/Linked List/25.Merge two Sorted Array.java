https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1?page=1&category=Linked%20List&sortBy=submissions

//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();
            Node head = obj.sortedMerge(head1, head2);
            printList(head);
        }
        sc.close();
    }
}

// } Driver Code Ends




/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node dNode=new Node(-1);
        Node t1=head1;
        Node t2=head2;
        Node temp=dNode;
        while(t1!=null && t2!=null)
        {
            if(t1.data<t2.data)
            {
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }
            else
            {
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            }
        }
        if(t1!=null) temp.next=t1;
        else temp.next=t2;
        return dNode.next;
    }
}
