let fullBinaryTree = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

function findParent(index) {
    return fullBinaryTree[Math.floor((index - 1)/2)]
}

function findChildren(index) {
    return [fullBinaryTree[(index*2)+1], fullBinaryTree[(index*2)+2]]
}
