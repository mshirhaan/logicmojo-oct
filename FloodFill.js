/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, color) {

    let rows = image.length
    let cols = image[0].length

    let visited = {}
    
    let queue = [[sr,sc]]

    let initColor = image[sr][sc]

    image[sr][sc] = color

    let directions = [[0,1], [0,-1], [-1, 0], [1, 0]]

    while(queue.length) {
        let [currentRow, currentCol] = queue.shift()

        for(let [offsetRow, offsetCol] of directions) {
            let newRow = currentRow + offsetRow
            let newCol = currentCol + offsetCol
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == initColor && !visited[newRow + "," + newCol]) {              
                queue.push([newRow, newCol])
                image[newRow][newCol] = color
                visited[newRow + "," + newCol] = true        
            }
        }
    }
    return image
    
};
