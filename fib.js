let count = 0;
function fib(n, map = {}) {
    if(map[n] != undefined) return map[n]
    count++
    if(n < 2) return n
    map[n] = fib(n-1, map) + fib(n-2, map)
    return map[n]
}
