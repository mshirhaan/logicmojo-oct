class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(0, candidates, 0, target,  new ArrayList<>(), new ArrayList<>() );
    }


public List<List<Integer>> helper(int index, int[] nums, int sum, int target ,List<Integer> bag, List<List<Integer>> trolly) {
   
    if(sum == target) {
        trolly.add(new ArrayList<>(bag));
        return null;
    }
    if(sum > target) return null;


    if(index == nums.length) {
        return null;
    }
    
    bag.add(nums[index]); //pick
    helper(index, nums, sum+nums[index], target, bag, trolly);

    bag.remove(bag.size()-1);
    helper(index+1, nums, sum, target, bag, trolly);

    return trolly;
}

}
