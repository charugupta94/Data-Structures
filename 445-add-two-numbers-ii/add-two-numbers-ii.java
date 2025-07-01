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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int n = size(l1);
        int m = size(l2);
        ListNode temp = null;
        if(n < m){
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        temp = l1;
        
        int carry = 0;
        ListNode prev = l1;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + carry;
            carry = val/10;
            l1.val = val%10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int val = l1.val + carry;
            carry = val/10;
            l1.val = val%10;
            prev = l1;
            l1 = l1.next;
        }
        if( carry > 0){
                ListNode node = new ListNode(carry);
                prev.next = node;
            }

        return reverse(temp);
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public int size(ListNode temp){
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}