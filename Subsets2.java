class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper(0, nums, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> helper(int index, int[] nums, List<Integer> bag, List<List<Integer>> trolly) {

        trolly.add(new ArrayList<>(bag));
            
        for(int i = index; i<nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;

            bag.add(nums[i]); //pick
            helper(i+1, nums, bag, trolly);
            bag.remove(bag.size()-1); 
        }

        return trolly;
    }

}
