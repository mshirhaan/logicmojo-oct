class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> helper(int[] nums, int i, List<Integer> bag, List<List<Integer>> trolly) {

        if(i == nums.length) {
            List<Integer> newBag = new ArrayList<>();
            newBag.addAll(bag);
            trolly.add(newBag);
            return trolly;
        }

        bag.add(nums[i]);
        helper(nums, i+1, bag, trolly);

        bag.remove(bag.size()-1);
        return helper(nums, i+1, bag, trolly);
    }
}
