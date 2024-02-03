let count = 0

let map = {}

let memo = {}

function targetSum(arr, target) {

    function helper(i, currentTarget, memo) {
        if(memo[i+","+currentTarget] != undefined) {
            return memo[i+","+currentTarget];
        }
        if(i == arr.length) {
            if(currentTarget == 0) {
                return [[]]
            }
            return null
        }

        count++
        map[i+","+currentTarget] = (map[i+","+currentTarget] || 0) + 1
        
        let left = helper(i+1, currentTarget - arr[i], memo);
        if(left) {
            left = left.map(bag => {
                return [...bag, arr[i]]
            })
        } else left = [];
        
        let right = helper(i+1, currentTarget, memo);
        if(!right) {
            right = [];
        }

        memo[i+","+currentTarget] = [...left, ...right];
        return memo[i+","+currentTarget];
        
    }

    return helper(0, target, memo)
}

targetSum([1, 2, 3,4,5,6,7,8], 20)
