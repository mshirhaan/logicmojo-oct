let adjList = {
    "A" : ["B", "C", "D" , "E"],
    "B" : ["A"],
    "C" : ["A", "G"],
    "D" : ["A"],
    "E" : ["F", "A"],
    "F" : ["E"],
    "G" : ["C"]

}

function bfs(adjList, root) {
    let visited = new Set();
    visited.add(root)

    let queue = [root]

    let res = []

    while (queue.length) {
        let size = queue.length;
        let level = []
        while(size > 0) {
            let curr = queue.shift()
            level.push(curr);
    
            for(let connection of adjList[curr]) {
                if(!visited.has(connection)) {
                    queue.push(connection)
                    visited.add(connection)
                }
            }
            size--;
        }
        res.push(level)
    }
    return res;
}

function dfs(adjList, root) {
    let res = [];
    let visited = new Set()

    helper(root)
    return res

    function helper(node) {
        visited.add(node)
        res.push(node)

        for(let connection of adjList[node]) {
            if(!visited.has(connection)) {
                helper(connection)
            }
        }
    }
}
