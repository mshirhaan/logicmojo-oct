/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */

function canIFill(grid, row, col, num) {

    for(let i = 0; i <=8; i++) {
        if(grid[row][i] == num || grid[i][col] == num) {
            return false;
        }
    }
    
    
    let rowGroup = Math.floor(row/3); //0 or 1 or 2
    let groupRowStart = rowGroup * 3;

    let colGroup = Math.floor(col/3); //0 or 1 or 2
    let groupColStart = colGroup * 3;

    for(let i = groupRowStart; i <= groupRowStart+2; i++) {
        for(let j = groupColStart; j <= groupColStart+2; j++) {
            if(i == row && j == col) continue;

            if(grid[i][j] == num) {
                return false;
            }
        }
    }

    return true;
}

function solveSudoku(grid) {
    helper(grid);
    return grid;
}

function helper(grid) {
    for(let row = 0; row < grid.length; row++) {
        for(let col = 0; col < grid.length; col++) {
            if(grid[row][col] == ".") {
                for(let num = 1; num <= 9; num++) {
                    if(canIFill(grid, row, col, num)) {
                        grid[row][col] = num+"";
                        let isComplete = helper(grid);
                        if(isComplete == true) {
                            return true;
                        }
                        grid[row][col] = ".";
                    }
                }
                return false;
            }
        }
    }
    
        return true;
    
}
