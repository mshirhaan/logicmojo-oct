class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(new ArrayList<>(), n, 0, res);
        return res;
    }

    public static void helper(List<Integer> board, int n, int row, List<List<String>> result) {
        if (row == n) {
            result.add(generateResultBoard(board, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canIPlace(board, row, i, n)) {
                board.add(i);
                helper(board, n, row + 1, result);
                board.remove(board.size() - 1);
            }
        }
    }

    public static boolean canIPlace(List<Integer> board, int row, int col, int n) {
        // column check
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i) == col) {
                return false;
            }
        }

        // right side upper diagonal
        for (int i = row - 1; i >= 0; i--) {
            if (col + (row - i) < n && board.get(i) == col + (row - i)) {
                return false;
            }
        }

        // left side upper diagonal
        for (int i = row - 1; i >= 0; i--) {
            if (col - (row - i) >= 0 && board.get(i) == col - (row - i)) {
                return false;
            }
        }

        return true;
    }

    public static List<String> generateResultBoard(List<Integer> board, int n) {
        List<String> resultBoard = new ArrayList<>();

        for (int col : board) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    str.append('Q');
                } else {
                    str.append('.');
                }
            }
            resultBoard.add(str.toString());
        }
        return resultBoard;
    }
}
