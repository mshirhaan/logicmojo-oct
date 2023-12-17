function topView() {
    let map = {}
    
    function bfs() {
        let queue = [[n1, 0]]
        while(queue.length) {
            let entry = queue.shift();
            let node = entry[0];
            let xaxis = entry[1];
            
            if(map[xaxis] == undefined) {
                map[xaxis] = node.val
            }
            
            if(node.left) queue.push([node.left, xaxis-1])
            if(node.right) queue.push([node.right, xaxis+1])
        }
    }
    bfs()
    return map
}

function leftView() {
    let map = {}
    
    function bfs() {
        let queue = [[n1, 0]]
        while(queue.length) {
            let entry = queue.shift();
            let node = entry[0];
            let yaxis = entry[1];
            
            if(map[yaxis] == undefined) {
                map[yaxis] = node.val
            }
            
            if(node.left) queue.push([node.left, yaxis+1])
            if(node.right) queue.push([node.right, yaxis+1])
        }
    }
    bfs()
    return map
}

function rightView() {
    let map = {}
    
    function bfs() {
        let queue = [[n1, 0]]
        while(queue.length) {
            let entry = queue.shift();
            let node = entry[0];
            let yaxis = entry[1];
            
            if(map[yaxis] == undefined) {
                map[yaxis] = node.val
            }
            if(node.right) queue.push([node.right, yaxis+1])
            if(node.left) queue.push([node.left, yaxis+1])
        }
    }
    bfs()
    return map
}

function bottomView() {
    let map = {}
    helper(n1, 0);
    return map
    

    function helper(node, xaxis) {
        if(node == null) return;
        helper(node.left, xaxis-1);
        helper(node.right, xaxis+1);
        if(map[xaxis] == undefined) {
            map[xaxis] = node.val
        }
    }
}
