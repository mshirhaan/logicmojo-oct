class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int answer[] = new int[n];

        answer[n-1] = 0;

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(n-1, temperatures[n-1]));

        for(int i = n-2; i >=0 ; i--) {
            int candidate = temperatures[i];
            while(stack.size() > 0 && stack.peek().getValue() <= candidate) {
                stack.pop();
            }
            if(stack.size() > 0) {
                answer[i] = stack.peek().getKey() - i;
            }
            stack.push(new Pair<>(i, candidate));
        }

        return answer;
    }
}
