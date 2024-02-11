var canJump = function(nums) {
    if(nums.length == 1) return true
    let target = 1;

    for(let i = nums.length-2; i>=0; i--) {
        if(nums[i] >= target) {
            target = 1;
        } else {
            target++;
        }
    }
    return nums[0] >= target
};
