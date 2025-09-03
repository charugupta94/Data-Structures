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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        int n = lists.length;
        if(lists == null || lists.length == 0)return null;
        for(int i = 0; i<n ;i++){
            if(lists[i] != null)
            pq.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode p = pq.peek();
            temp.next = p;
            temp = temp.next;
            pq.poll();
            if(p.next != null){
                pq.add(p.next);
            }
        
        }
        return dummy.next;
    }
}


// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         int n = lists.length;
//         if(n == 0)return null;
//         if(n == 1)return lists[0];
//         ListNode head = lists[0];
//         for(int i = 1;i<n;i++){
//             head = mergelist(head,lists[i]);
//         }
//         return head;
//     }
//     public ListNode mergelist(ListNode list1 , ListNode list2){
//         ListNode temp1= list1;
//         ListNode temp2= list2;
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         while(temp1 != null && temp2 != null){
//             if(temp1.val <= temp2.val){
//                 curr.next = temp1;
//                 temp1 = temp1.next;
//             }
//             else{
//                 curr.next = temp2;
//                 temp2 = temp2.next;
//             }
//             curr = curr.next;
//         }
//         while(temp1  != null){
//             curr.next = temp1;
//             temp1 = temp1.next;
//             curr = curr.next;
//         }
//         while(temp2  != null){
//             curr.next = temp2;
//             temp2 = temp2.next;
//             curr = curr.next;
//         }
//         return dummy.next;
//     }
// }