var addOperators = function(num, target) {
    let resultExpressions = [];


    function helper(index, currResult, prevNumber, prevOperator, currExpression) {
        if(index == num.length) {
            if(currResult == target) {
                resultExpressions.push(currExpression)
                return
            }
        }
        
        for(let i = index; i < num.length; i++) {
            let currNum = Number(num.substring(index, i+1));
            console.log(currNum)

            if(currExpression == '') {
                helper(i+1, currResult+currNum, currNum, '', `${currNum}`)
                if(currNum == 0) {
                    break;
                }
                continue;
            }

            helper(i+1, currResult+currNum, currNum, '+', `${currExpression}+${currNum}`)
            helper(i+1, currResult-currNum, currNum, '-', `${currExpression}-${currNum}`)

            
            let newResult;
            if(prevOperator == '+') {
               newResult = (currResult - prevNumber) + (prevNumber * currNum);
            } else if (prevOperator == '-') {
                newResult = (currResult + prevNumber) - (prevNumber * currNum);
            } else {
                newResult = currResult * currNum
            }
            
            
            helper(i+1, newResult, currNum, '*', `${currExpression}*${currNum}`)
            if(currNum == 0) {
                break;
            }
        }
    }

    helper(0, 0, null, '', '')
    return resultExpressions;
};
