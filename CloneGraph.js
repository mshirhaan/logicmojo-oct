/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(originalStartNode) {
    if(!originalStartNode) return null
    
    let map = new Map()
    let visited = new Map()
    
    let queue = [originalStartNode]
    visited.set(originalStartNode, true)
    
    while(queue.length) {
        let node = queue.shift()
       
        let cloneNode = map.get(node)
        if(!cloneNode) {
            cloneNode = new Node(node.val)
            map.set(node, cloneNode)
        }
        for(let neighbor of node.neighbors) {
            let neighborClone = map.get(neighbor)
            if(!neighborClone) {
                neighborClone = new Node(neighbor.val)
                map.set(neighbor, neighborClone)
            }
            cloneNode.neighbors.push(neighborClone)
            if(!visited.get(neighbor)) {
                queue.push(neighbor)
                visited.set(neighbor, true)
            }
        }
    }
    return map.get(originalStartNode)
};
