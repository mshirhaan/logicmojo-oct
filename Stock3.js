class Solution {
    public int maxProfit(int[] prices) {
        return helper(0, 2, true, prices, new HashMap<>());
    }

    private int helper(int i, int transactionLeft, boolean canIBuy, int[] prices, Map<String, Integer> memo) {
        if (i == prices.length || transactionLeft == 0) return 0;

        String key = i + "," + transactionLeft + "," + canIBuy;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = 0;
        int right = 0;

        if (canIBuy) {
            left = -prices[i] + helper(i + 1, transactionLeft, false, prices, memo);
            right = helper(i + 1, transactionLeft, true, prices, memo);
        } else {
            left = prices[i] + helper(i + 1, transactionLeft - 1, true, prices, memo);
            right = helper(i + 1, transactionLeft, false, prices, memo);
        }

        int result = Math.max(left, right);
        memo.put(key, result);
        return result;
    }
}
