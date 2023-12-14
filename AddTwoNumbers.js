var addTwoNumbers = function(l1, l2) {
    return helper(l1, l2, 0);
};


function helper(n1, n2, carry) {
    if((n1 == null && n2 == null && carry == 0)) {
        return null;
    }
    let sum = new ListNode();
    sum.val = ((n1 && n1.val) || 0) + ((n2 && n2.val) || 0) + (carry || 0);
    if(sum.val > 9) {
        carry = 1;
        sum.val = sum.val % 10
    } else {
        carry = 0;
    }
    
    sum.next = helper((n1 && n1.next) || null, (n2 && n2.next) || null, carry);
    return sum;
}

