class Solution {
    public int totalNQueens(int n) {
        
        return helper(new ArrayList<>(), n, 0);
    }

    public static int helper(List<Integer> board, int n, int row) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (canIPlace(board, row, i, n)) {
                board.add(i);
                count+= helper(board, n, row + 1);
                board.remove(board.size() - 1);
            }
        }

        return count;
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
