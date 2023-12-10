class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return levelsCount(root);
    }

    public int levelsCount(TreeNode root) {
        int levelCount = 0;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            levelCount++;
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode curr = queue.poll();
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
                levelSize--;
            }
        }
        return levelCount;
    }
}


//Recursive way
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int leftCount = helper(root.left);
        int rightCount = helper(root.right);
        return Math.max(leftCount, rightCount) + 1;
    }
}
