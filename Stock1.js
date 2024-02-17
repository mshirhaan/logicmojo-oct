var maxProfit = function(prices) {
    let maxProfit = 0
    let whatYouBought = Infinity;

    for(let price of prices) {
        if(price < whatYouBought) {
            whatYouBought = price
        } else {
            maxProfit = Math.max(maxProfit, price - whatYouBought)
        }
    }

    return maxProfit;
};
