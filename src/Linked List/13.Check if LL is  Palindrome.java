https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1?page=1&category=Linked%20List&sortBy=submissions

/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        Node temp=head;
        Stack<Integer> st= new Stack<>();

        while(temp!=null)
        {
            st.push(temp.data);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null)
        {
            if(temp.data!=st.peek())
            {
                return false;
            }
            st.pop();
            temp=temp.next;
        }
        return true;
    }
}


