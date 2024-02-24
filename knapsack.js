function knapsack(weights, values, totalCapacity) {

    let perUnitPrice = []

    for(let i = 0; i < weights.length; i++) {
        perUnitPrice[i] = [values[i] / weights[i], i]
    }

    perUnitPrice.sort((a,b) => b[0]-a[0])

    let resultPrice = 0

    for(let i = 0; i < weights.length; i++) {
        resultPrice+= perUnitPrice[i][0] * (Math.min(totalCapacity,weights[perUnitPrice[i][1]]))
        totalCapacity-= weights[perUnitPrice[i][1]]
        if(totalCapacity<=0) break
    }

    return resultPrice
}
