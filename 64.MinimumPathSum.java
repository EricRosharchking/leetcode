public class MinimumPathSum {
    public static void main(String[] args) {
        
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathValue = new int[m][n];
        int val = 0;
        for (int i = 0; i < n; i++) {
            val += grid[0][i];
            pathValue[0][i] = val;
        }
        val = pathValue[0][0];
        for (int i = 1; i < m; i++) {
            val += grid[i][0];
            pathValue[i][0] = val;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (pathValue[i-1][j] < pathValue[i][j-1]) {
                    pathValue[i][j] = pathValue[i-1][j]+grid[i][j];
                } else {
                    pathValue[i][j] = pathValue[i][j-1]+grid[i][j];
                }
            }
            
        }
        return pathValue[m-1][n-1];
    }
}
