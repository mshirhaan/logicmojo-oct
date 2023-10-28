class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;
        for(int i = 0; i<height.length; i++) {
            left[i] = max;
            if(height[i] > max) {
                max = height[i];
            }
        }

        max = 0;

        for(int i = height.length-1; i>=0; i--) {
            right[i] = max;
            if(height[i] > max) {
                max = height[i];
            }
        }


        int waterCount = 0;

        for(int i = 0; i<height.length; i++) {
            int count = Math.min(left[i], right[i]) - height[i];
            if(count>0) {
                waterCount+= count;
            }
        }
        return waterCount;

    }
}
