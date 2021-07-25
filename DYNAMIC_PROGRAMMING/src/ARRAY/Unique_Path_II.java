package ARRAY;

public class Unique_Path_II {

    public static void main(String[] args) {

        // int[][] array = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] array = new int[][] { { 0, 1 }, { 0, 0 } };

        int result_uniquePathsWithObstacles = uniquePathsWithObstacles(array);
        System.out.println(result_uniquePathsWithObstacles);

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid == null)
            return 0;

        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i == 0 || j == 0) && obstacleGrid[i][j] != 1) {
                    dp[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][column - 1];
    }

}
