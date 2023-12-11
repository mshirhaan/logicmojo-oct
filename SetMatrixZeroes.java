class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int fRow = 1;
        int fCol = 1;

        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) {
                fCol = 0;
            }
        }

        for(int i = 0; i < cols; i++) {
            if(matrix[0][i] == 0) {
                fRow = 0;
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(fRow == 0) {
            for(int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if(fCol == 0) {
            for(int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
