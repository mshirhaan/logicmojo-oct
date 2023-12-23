var diameterOfBinaryTree = function(root) {
    let max = 0;
    
    helper(root)
    return max;
    
    function helper(node) {
        if(node.left == null && node.right == null) {
            return 0;
        }
        let left = 0, right = 0, sum = 0
        
        if(node.left) {
            left = helper(node.left)
            sum+=1+left
        }
        if(node.right) {
            right = helper(node.right)
            sum+=1+right
        }
        
        max = Math.max(max, sum)
        
        return 1 + Math.max(left, right)
    }
};
