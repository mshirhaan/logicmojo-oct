/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
    if(prerequisites.length == 0) return true
    let map = {}
    let visited = {}


    //constrcution of map
    for(let prerequisite of prerequisites) {
        let [pre, curr] = prerequisite
        map[curr] = map[curr] || []
        map[curr].push(pre)
    }

    //try to complete one by one
    for(let key in map) {
        if(!visited[key]) {
            if(!dfs(key)) {
                return false
            }
        }
        
    }

    return true
    
    function dfs(key) {
        if(visited[key]) {
            return false;
        }
        if(!map[key]) {
            return true
        }

        visited[key] = true
        for(let i = 0; i < map[key].length; i++) {
            let dependency = map[key][i]
            if(dfs(dependency)) {
                map[key].shift()
                i--
            } else {
                return false
            }
        }
        delete visited[key]
        return true;
    }
};
