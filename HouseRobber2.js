var rob = function (nums) {
    if(nums.length == 1) return nums[0]
    let first = oldRob(nums.slice(0, nums.length-1));
    let second = oldRob(nums.slice(1));
    return Math.max(first, second)
}

var oldRob = function(nums) {
    
    function helper(i, canIRob, memo = {}) {
        if(memo[i+","+canIRob] != undefined) {
            return memo[i+","+canIRob]
        }
        if(i == nums.length) {
            return 0
        }
        let left = 0;
        if(canIRob) {
            left = nums[i] + helper(i+1, false, memo)
        } 
        let right = helper(i+1, true, memo)
        memo[i+","+canIRob] = Math.max(left, right)
        return memo[i+","+canIRob]
    }

    return helper(0, true)
};
