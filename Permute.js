var permute = function(nums) {
    let map = {};
    let res = [];
    let bag = [];

    helper(nums, res, bag);
    return res;

    function helper(nums,res, bag) {
        if(bag.length == nums.length) {
            res.push([...bag]);
            return;
        }
        for(let i = 0; i<nums.length; i++) {
            if(map[nums[i]]) continue;
            bag.push(nums[i]);
            map[nums[i]] = true;
            helper(nums, res, bag);
            bag.pop();
            map[nums[i]] = false;
        }
    }
};
