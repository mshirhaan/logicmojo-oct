function verticalTraversal(root) {
    let map = {}
    let n = 0;
    
    function bfs() {
        let queue = [[root, 0]]
        while(queue.length) {
            let size = queue.length
            let level = {}
            while(size > 0) {
                let entry = queue.shift();
                let node = entry[0];
                n++;
                let xaxis = entry[1];

                if(level[xaxis] == undefined) {
                    level[xaxis] = [node.val]
                } else {
                    level[xaxis].push(node.val)
                }

                if(node.left) queue.push([node.left, xaxis-1])
                if(node.right) queue.push([node.right, xaxis+1])
                size--
            }
            for(let key in level) {
                level[key].sort((a,b) => a-b)
                if(!map[key]) map[key] = [];
                map[key] = [...map[key], ...level[key]];
            }
        }
    }
    bfs()
    let res = [];
    for(let i = -n+1; i <= n-1; i++) {
        if(map[i] != undefined) {
            res.push(map[i]);
        }
    }
    return res;
    
}

function levelOrder() {
    let queue = [n1]
    let res = []
    while(queue.length) {
        let size = queue.length
        let level = []
        while(size > 0) {
            let node = queue.shift();
            level.push(node.val)
            if(node.left) queue.push(node.left)
            if(node.right) queue.push(node.right)
            size--
        }
        res.push(level)
    }
    return res;
}
