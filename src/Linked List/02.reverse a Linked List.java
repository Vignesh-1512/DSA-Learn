https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1?page=1&category=Linked%20List&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        // code here
        Node curr = head;
        Node prevNode = null;
        Node nextNode = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prevNode;    //actual changing Link
            prevNode = curr;
            curr = nextNode;
        }
        return prevNode;
    }
}
