https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    static Node reverse(Node head)
    {
        Node curr = head;
        Node prevNode = null;
        Node nextNode = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        return prevNode;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        Node t1=reverse(num1);
        Node t2=reverse(num2);

        Node dummy=new Node(-1);
        Node curr=dummy;
        int carry=0;
        while(t1 != null || t2 != null)
        {
            int sum=carry;
            if(t1 != null){
                sum += t1.data;
                t1 = t1.next;
            }
            if(t2 != null){
                sum += t2.data;
                t2 = t2.next;
            }

            Node newNode=new Node(sum % 10);
            carry=sum/10;
            curr.next=newNode;
            curr=curr.next;


        }
        if(carry > 0)
        {
            Node newNode=new Node(carry);
            curr.next=newNode;
        }
        return reverse(dummy.next);
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends