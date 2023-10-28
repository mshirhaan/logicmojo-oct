class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int max = 1;

        Arrays.sort(nums); //O(nlogn)

        int count = 1;

        int i = 1;

        while(i<nums.length) {
            if(nums[i] == nums[i-1]) {
                i++;
                continue;
            };

            if(nums[i] == nums[i-1]+1) {
                count++;
                if(count > max) max = count;
            } else {
                count = 1;
            }
            i++;
        }
        return max;
    }
}
