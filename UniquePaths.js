//Top down
var uniquePaths = function(m, n, map = {}) {

    function helper(row, col) {
        if(map[row+","+col] != undefined) return map[row+","+col];
        
        if(row >= m || col >= n) return 0
        if(row == m-1 && col == n-1) return 1

        map[row+","+col] = helper(row+1, col) + helper(row, col+1)
        return map[row+","+col];
    }

    return helper(0,0)
};


//Bottom up
var uniquePaths = function(m, n) {
    let grid = []

    for(let i = 0 ; i < m; i++) {
        grid.push([])
    }

    for(let i = 0; i < n; i++) {
        grid[m-1][i] = 1
    }

    for(let i = 0; i < m; i++) {
        grid[i][n-1] = 1
    }

    for(let i = m - 2; i >= 0; i--) {
        for(let j = n - 2; j >= 0; j--) {
            grid[i][j] = grid[i+1][j] + grid[i][j+1]
        }
    }

    return grid[0][0]
};

//Bottom up space optimised
var uniquePaths = function(m, n) {
    let currentRow = []

    for(let i = 0 ; i < n; i++) {
        currentRow.push(1)
    }

    for(let i = 0; i < m-1; i++) {
        for(let j = n - 2; j >= 0; j--) {
            currentRow[j] = currentRow[j+1] + currentRow[j]
        }
    }
   
    return currentRow[0]
};
