var largestRectangleArea = function(heights) {

    let n = heights.length;

    let leftSmallest = [0];

    let stack = [0];
    for(let i = 1; i < n; i++) {
        while(heights[i] <= heights[stack.at(-1)]) {
            stack.pop();
        }
        if(stack.length) {
            leftSmallest.push(i-stack.at(-1)-1);
        } else {
            leftSmallest.push(i);
        }
        stack.push(i);
    }

    let rightSmallest = [];
    rightSmallest[n-1] = 0

    stack = [n-1];
    for(let i = n-2; i >= 0; i--) {
        while(heights[i] <= heights[stack.at(-1)]) {
            stack.pop();
        }
        if(stack.length) {
            rightSmallest[i] = stack.at(-1) - i - 1;
        } else {
            rightSmallest[i] = (n - i - 1);
        }
        stack.push(i);
    }

    let max = 0;

    for(let i = 0; i < heights.length; i++) {
        let candidate = (leftSmallest[i] + rightSmallest[i] + 1) * heights[i];
        if(candidate > max) {
            max = candidate;
        }
    }

    return max;
};

largestRectangleArea([1,1])
