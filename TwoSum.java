class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i<nums.length; i++) {
            int need = target - nums[i];
            if(map.containsKey(need)) {
                int j = map.get(need);
                return new int[]{i, j};
            } 
            map.put(nums[i] , i);
        }

        return new int[]{-1, -1};
    }
}
