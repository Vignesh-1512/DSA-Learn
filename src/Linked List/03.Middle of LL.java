https://leetcode.com/problems/middle-of-the-linked-list/

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
    public ListNode middleNode(ListNode head) {
        int ct=0;
        ListNode temp=head;
        while(temp!=null)
        {
            ct++;
            temp=temp.next;
        }
        int pos=ct/2;
        while(pos>0)
        {
            head=head.next;
            pos--;
        }
        return head;
    }
}