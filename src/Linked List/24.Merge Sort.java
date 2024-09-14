https://www.geeksforgeeks.org/problems/sort-a-linked-list/1?page=2&category=Linked%20List&sortBy=submissions

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


// } Driver Code Ends
/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    static Node merge(Node x, Node y)
    {
        if(x==null) return y;
        if(y==null) return x;

        Node curr = null;
        if(x.data<=y.data)
        {
            curr = x;
            curr.next = merge(x.next,y);
        }else{
            curr = y;
            curr.next = merge(x,y.next);
        }
        return curr;
    }
    static Node middle(Node head)
    {
        Node fast = head;
        Node slow = head;
        Node prevSlow = null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        return prevSlow;
    }
    static Node mergeSort(Node head)
    {
        if(head==null)  return null;
        if(head.next==null) return head;

        Node firstHalfTail = middle(head);
        Node secondHalfHead = firstHalfTail.next;
        firstHalfTail.next = null;

        head = mergeSort(head);
        secondHalfHead = mergeSort(secondHalfHead);
        return merge(head,secondHalfHead);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends