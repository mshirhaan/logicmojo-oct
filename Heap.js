let heap = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

function findParent(index) {
    return heap[Math.floor((index - 1)/2)]
}

function findChildren(index) {
    return [heap[(index*2)+1], heap[(index*2)+2]]
}

class Heap {
    arr = []

    extractMin() {
        if(this.arr.length == 0) return null

        let min = this.arr[0]

        if(this.arr.length >=2) {
            let last = this.arr.pop()
            this.arr[0] = last
            this.settleDown()
        } else {
            this.arr.pop()
        }
        

        return min
    }

    settleDown() {
        let currIdx = 0
        let child1Idx = (currIdx*2)+1
        let child2Idx = (currIdx*2)+2

        while((this.arr[currIdx] > this.arr[child1Idx]) || (this.arr[currIdx] > this.arr[child2Idx])) {
            if(this.arr[child1Idx] <= this.arr[child2Idx]) {
                this.swap(this.arr, currIdx, child1Idx)
                currIdx = child1Idx
                
            } else {
                this.swap(this.arr, currIdx, child2Idx)
                currIdx = child2Idx
            }
            child1Idx = (currIdx*2)+1
            child2Idx = (currIdx*2)+2

            if(child1Idx >= this.arr.length - 1 && child2Idx >= this.arr.length - 1) return
        }
    }

    insert(number) {
        this.arr.push(number)
        this.heapify()
    }

    heapify() {
        if(this.arr.length <=1) return;
        
        let currIdx = this.arr.length - 1
        let parentIdx = Math.floor((currIdx - 1)/2)

        while(this.arr[currIdx] < this.arr[parentIdx]) {
            this.swap(this.arr,currIdx, parentIdx)
            // let temp = this.arr[currIdx]
            // this.arr[currIdx] = this.arr[parentIdx]
            // this.arr[parentIdx] = temp

            currIdx = parentIdx
            parentIdx = Math.floor((currIdx - 1)/2)

            if(currIdx == 0) {
                return;
            }
        }
    }

    swap(arr, i, j) {
        let temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
