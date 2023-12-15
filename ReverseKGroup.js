var reverseKGroup = function(head, k) {
    return helper( head);
    
    function helper(start) {
        let count = 0;
        let curr = start;
        while(count < k) {
            if(curr == null) return start;
            curr = curr.next;
            count++;
        }
        
        let prev = null;
        curr = start;
        let next;
        
        count = 0
        while(count < k) {
            next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        start.next = helper(next);
        return prev
    }
};
