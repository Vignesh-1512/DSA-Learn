https://www.naukri.com/code360/problems/insertion-in-a-singly-linked-list_4609646?leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*;

/************************************************************

 Following is the linkedList class structure:

 class Node<T> {
 T data;
 Node<T> next;

 public Node(T data) {
 this.data = data;
 }
 }

 ************************************************************/

public class Solution {

    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.
        // Create the new node with the given value
        Node newNode = new Node(val);
        if(pos==0)
        {
            newNode.next=head;
            return newNode;
        }


        // Case 2: Insert at a position other than the head
        Node temp = head;
        int ct = 0;

        // Traverse to the node just before the desired position
        while (temp != null && ct < pos - 1) {
            temp = temp.next;
            ct++;
        }

        // Insert the new node if the position is valid
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Return the (possibly new) head of the list
        return head;
    }
}