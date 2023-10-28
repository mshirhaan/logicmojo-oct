//3loops
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        int leftP = 1;
        int rightP = 1;

        for(int i = 0; i<nums.length; i++) {
            left[i] = leftP;
            leftP = leftP * nums[i];
        }
        for(int i = nums.length-1; i>= 0; i--) {
            right[i] = rightP;
            rightP = rightP * nums[i];
        }

        for(int i = 0; i<nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        

        return res;
    }
}


//1 Loop
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int leftP = 1;
        int rightP = 1;

        for(int i = 0; i<nums.length; i++) {
            res[i] = res[i] * leftP;
            leftP = leftP * nums[i];
            
            res[n-1-i] = res[n-1-i] * rightP;
            rightP = rightP * nums[n-1-i];
        }
            
        return res;
    }
}
