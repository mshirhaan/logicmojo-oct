let adjacencyMatrix = {};

function addEdge(vertex1, vertex2, weight) {
    if (!adjacencyMatrix[vertex1]) {
        adjacencyMatrix[vertex1] = [];
    }
    if (!adjacencyMatrix[vertex2]) {
        adjacencyMatrix[vertex2] = [];
    }
    adjacencyMatrix[vertex1].push({ vertex : vertex2, weight: weight});
    adjacencyMatrix[vertex2].push({ vertex : vertex1, weight: weight});

}

addEdge("A", "B", 6);

addEdge("A", "D", 1);

addEdge("B", "D", 2);

addEdge("B", "E", 2);

addEdge("D", "E", 1);

addEdge("B", "C", 5);

addEdge("E", "C", 5);

class Heap {
    arr = []

    add(vertex, distance, prev) {
        this.arr.push({vertex, distance, prev})
        this.arr.sort((a,b) => a.distance - b.distance)
    }
    getMin() {
        return this.arr.shift()
    }
}

function diji (adjacencyMatrix) {
    let heap = new Heap()
    let distance = {
        A: {distance: 0, prev: null},
        B: {distance: Infinity, prev: null},
        C: {distance: Infinity, prev: null},
        D: {distance: Infinity, prev: null},
        E: {distance: Infinity, prev: null}
    }

    let visited = new Set()

    heap.add("A", 0, null)

    while(heap.arr.length) {
        let min = heap.getMin()

        if(visited.has(min.vertex)) continue

        distance[min.vertex].distance = min.distance
        distance[min.vertex].prev = min.prev

        for(let connection of adjacencyMatrix[min.vertex]) {
            if(visited.has(connection.vertex)) continue
            heap.add(connection.vertex, min.distance + connection.weight, min.vertex);
        }
        visited.add(min.vertex);
    
    }
}
