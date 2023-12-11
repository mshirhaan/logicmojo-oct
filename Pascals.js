var generate = function(numRows) {
    let res = [[1]]
    for(let i = 2; i <= numRows; i++) {
        let newRow = generateRow(i, res)
        res.push(newRow)
    }
    return res;
};

function generateRow(rowNumber, currentState) {
    let newRow = []
    let prevRow = currentState[rowNumber-2] //-2 because of 1 indexing
    
    //number of columns to add to new row is same as rowNumber
    //so loop is on that
    for(let i = 0; i<rowNumber; i++) {
        newRow[i] = (prevRow[i-1] || 0) + (prevRow[i] || 0)
    }
    return newRow;
}
