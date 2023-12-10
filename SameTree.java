class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode first, TreeNode second){
        if(first == null && second == null){
            return true;
        }
        
        if(first == null || second == null || first.val !=second.val){
            return false;
        }
        return helper(first.left,second.left) && helper(first.right,second.right);
    }
}
