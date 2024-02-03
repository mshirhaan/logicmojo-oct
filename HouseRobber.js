var rob = function(nums) {
    
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
