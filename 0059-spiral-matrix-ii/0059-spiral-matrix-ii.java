class Solution {
    public int[][] generateMatrix(int n) {
        // Beats 100%
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int res[][] = new int[n][n];
        int count = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res[top][j] = count++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                res[j][right] = count++;
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res[bottom][j] = count++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    res[j][left] = count++;
                }
                left++;
            }
        }
        return res;
    }
}