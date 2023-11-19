//Extra space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;

        while(curr!=null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while(curr!=null) {
            if(set.contains(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }
}

//O(1) space
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int firstCount = 0;
        int secondCount = 0;

        ListNode curr = headA;

        while(curr!=null) {
            firstCount++;
            curr = curr.next;
        }

        curr = headB;
        while(curr!=null) {
            secondCount++;
            curr = curr.next;
        }

        ListNode first = headA, second = headB;


        if(firstCount > secondCount) {
            //skip starting from first linked list
            int numberOfNodesToSkip = firstCount - secondCount;
            while(numberOfNodesToSkip>0) {
                first = first.next;
                numberOfNodesToSkip--;
            }
        } else {
             //skip starting from second linked list
             int numberOfNodesToSkip = secondCount - firstCount;
             while(numberOfNodesToSkip>0) {
                second = second.next;
                numberOfNodesToSkip--;
            }
        }

        while(first!= null && second!=null) {
            if(first == second) return first;

            first = first.next;
            second = second.next;
        }


        return null;
    }
}

//Refactored
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int firstCount = 0;
        int secondCount = 0;

        ListNode curr = headA;

        while(curr!=null) {
            firstCount++;
            curr = curr.next;
        }

        curr = headB;
        while(curr!=null) {
            secondCount++;
            curr = curr.next;
        }

        ListNode first = headA, second = headB;


        if(firstCount > secondCount) {
            //skip starting from first linked list
            first = skipNodes(first, firstCount - secondCount);
        } else {
             //skip starting from second linked list
             second = skipNodes(second, secondCount - firstCount );
        }

        while(first!= null && second!=null) {
            if(first == second) return first;

            first = first.next;
            second = second.next;
        }

        return null;
    }

    private ListNode skipNodes(ListNode node, int countToSkip) {
            while(countToSkip>0) {
                node = node.next;
                countToSkip--;
            }
            return node;
    }
}

//Without counting length approach https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
