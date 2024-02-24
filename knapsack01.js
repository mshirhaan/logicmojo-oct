//Recursion
function knapsack(weights, values, totalCapacity) {


    function helper(i, capacityLeft, memo = {}) {
        if(memo[i+","+capacityLeft] != undefined) {
            return memo[i+","+capacityLeft]
        }
        
        if(capacityLeft == 0 || i == weights.length) {
            return 0;
        }
        
        let left = 0;
        let right = 0;

        if(weights[i] <= capacityLeft) {
            left = values[i] + helper(i+1, capacityLeft-weights[i], memo);
        }
        right = helper(i+1, capacityLeft, memo);

        memo[i+","+capacityLeft] = Math.max(left, right)
        return memo[i+","+capacityLeft]
    }

    return helper(0, totalCapacity)
}



//Tabulation
function knapsack(weights, values, totalCapacity) {

    let n = weights.length
    
    let memo = []
    memo[n-1] = []

    for(let i = totalCapacity; i >= 0; i--) {
        memo[n-1][i] = weights[n-1] <= i ? values[n-1] : 0; 
    }
    
    for(let row = n-2; row >= 0; row--) {
        memo[row] = []
        for(let i = totalCapacity; i >= 0; i--) {
            let candidate = 0;
            if(weights[row]<= i) {
                candidate = values[row] + memo[row+1][i-weights[row]]
            }
            
            memo[row][i] = Math.max(memo[row+1][i], candidate)
        }
    }
    
    return memo[0][totalCapacity]
    
}




knapsack([2,3,4],[50,100,120],  5)
