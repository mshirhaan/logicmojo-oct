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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }

        //find the mid
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;

        slow.next = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode right = prev;
        ListNode left = head;

        boolean isLeft = true;

        ListNode dummy = new ListNode(0);

        while(left != null || right != null) {
           if(isLeft) {
               dummy.next = left;
               left = left.next;
               
           } else {
               dummy.next = right;
               right = right.next;
           }
           isLeft = !isLeft;
           dummy = dummy.next;
        }
    }
}
