var rotateRight = function(head, k) {
    if(k == 0 || !head) {
        return head;
    }
    
    let fast = head;
    let slow = head;
    
    let n = 0;
    while(fast!=null) {
        n++;
        fast = fast.next;
    }
    
    k = k % n;
    if(k == 0 ) {
        return head;
    }
    fast = head;
    
    let count = 0;
    
    while(count++<k && fast) {
        console.log(count)
        fast = fast.next;
    }
    
    while(fast.next!=null) {
        slow = slow.next;
        fast = fast.next;
    }
    
    let newHead = slow.next;
    fast.next = head
    slow.next = null;
    
    return newHead;
    
};
