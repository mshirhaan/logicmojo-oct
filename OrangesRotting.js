var orangesRotting = function(grid) {
    let directions = [[0,1],[1,0], [0,-1], [-1, 0]]

    let queue = []

    let timer = 0

    let m = grid.length
    let n = grid[0].length

    for(let i = 0; i < m ;i++) {
        for(let j = 0; j < n; j++) {
            if(grid[i][j] == 2) {
                queue.push({row: i, col: j, time: 0})
            }
        }
    }

    console.log(queue)

    while(queue.length) {
        let size = queue.length
        while(size > 0) {
            let {row, col, time} = queue.shift();
            
            for(let [dRow, dCol] of directions) {
                let newRow = row+dRow
                let newCol = col+dCol
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    queue.push({row: newRow, col: newCol, time: time + 1})
                    grid[newRow][newCol] = 2
                    timer = time+1
                }
            }
            size--;
        }
    }

    for(let i = 0; i < m ;i++) {
        for(let j = 0; j < n; j++) {
            if(grid[i][j] == 1) {
                return -1
            }
        }
    }

    return timer
};
