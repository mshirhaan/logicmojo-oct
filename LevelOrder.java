class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        Queue <TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);


        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelItems = new ArrayList<>();
            while(levelSize > 0) {
                TreeNode curr = queue.poll();
                levelItems.add(curr.val);
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
                levelSize--;
            }
            result.add(levelItems);
        }
        return result;
    }
}
