var subarraySum = function(nums, k) {
    let map = {};

    let count = 0;

    let sum = 0;

    for(let i = 0; i < nums.length; i++) {
        sum+= nums[i];
        if(sum == k){
            count++;
        }
        if(map[sum-k] != undefined) {
            count+=map[sum-k];
        }
        map[sum] = (map[sum] || 0)+1
    }
    return count;
};
