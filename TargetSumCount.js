let count = 0

function targetSum(arr, target) {

    function helper(i, sum, map = {}) {
        if(map[i+","+sum] != undefined) return map[i+","+sum];
        
        count++;
        if(i == arr.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        let left = helper(i+1, sum+arr[i], map)
        
        let right = helper(i+1, sum, map)
        map[i+","+sum] = left+right
        return left+right
    }

    return helper(0, 0)
}

targetSum([1, 3, 4, 2, 6, 5], 8)
