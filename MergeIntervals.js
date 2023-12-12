var merge = function(intervals) {
    //destructing the 0th index value of 2 intervals
    intervals.sort(([i1Start], [i2Start])=>i1Start - i2Start);

    let res = [intervals[0]]

    for(let i = 1; i < intervals.length; i++) {
        if(intervals[i][0] <= res.at(-1)[1]) {
            res.at(-1)[1] = Math.max(res.at(-1)[1], intervals[i][1]);
        } else {
            res.push(intervals[i])
        }
    }
    return res;
};
