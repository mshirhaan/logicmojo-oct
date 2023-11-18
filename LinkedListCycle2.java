public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                // reset any one pointer to head
                slow = head;

                //now move equal steps and where they meet is the start of cycle
                while(slow != fast) {
                   slow = slow.next;
                   fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
