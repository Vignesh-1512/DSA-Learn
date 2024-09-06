https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?page=1&category=Linked%20List&sortBy=submissions

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
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here

        // Create dummy nodes for the lists of 0s, 1s, and 2s.
        Node ZeroHead=new Node(-1);
        Node OneHead=new Node(-1);
        Node TwoHead=new Node(-1);

        // Pointers to traverse the 0s, 1s, and 2s lists.
        Node zero=ZeroHead;
        Node one=OneHead;
        Node two=TwoHead;

        Node temp=head;

        // Traverse the original list and segregate the nodes.
        while(temp!=null)
        {
            if(temp.data==0)
            {
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1)
            {
                one.next=temp;
                one=one.next;
            }
            else
            {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }

        // Connect the 0s list to the 1s list, or directly to the 2s list if no 1s exist.
        zero.next=(OneHead.next!=null) ? OneHead.next : TwoHead.next;

        // Connect the 1s list to the 2s list.
        one.next=TwoHead.next;

        // Terminate the 2s list.
        two.next=null;

        // The new head is the beginning of the 0s list.
        Node newHead=ZeroHead.next;

        return newHead;
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
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends

