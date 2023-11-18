//TC : O(n) || SC : O(n)
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;

        while(curr!= null) {
            if(set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

//TC : O(n) || SC : O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        } 
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
