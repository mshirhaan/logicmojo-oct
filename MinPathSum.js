/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    let m = grid.length
    let n = grid[0].length

    function helper(row, col, memo = {}) {
        if(memo[row+","+col] != undefined) {
            return memo[row+","+col]
        }
        if(row == m || col == n) {
            return Infinity;
        }

        if(row == m-1 && col == n-1) {
            return grid[row][col]
        }
        let right = helper(row, col+1, memo)
        let down = helper(row+1, col, memo)

        memo[row+","+col] = grid[row][col] + Math.min(right, down)
        return memo[row+","+col]
    }

    return helper(0, 0)
};
