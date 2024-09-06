https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode temp=head;
        int cnt=0;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if (cnt == n) {
            ListNode newhead = head.next;
            head = null;
            return newhead;
        }
        int res=cnt-n;
        temp=head;
        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        ListNode deleteNode=temp.next;
        temp.next=temp.next.next;
        return head;
    }
}

//Method-2:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        while(fast==null)
        {
            return head.next;
        }
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;

        }


        ListNode deleteNode=slow.next;
        slow.next=slow.next.next;

        return head;
    }
}