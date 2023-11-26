public class PathWithMaximumGold {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int max, m, n;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid)); // 7+8+9 = 24
    }

    public static int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    dfs(grid, i, j, grid[i][j]);
            }
        }
        return max;
    }

    public static void dfs(int[][] grid, int x, int y, int value) {
        max = Math.max(max, value);

        int temp = grid[x][y];
        grid[x][y] = 0;
        for (int[] dir : directions) {
            int xn = x + dir[0];
            int yn = y + dir[1];
            if (xn >= 0 && xn < m && yn >= 0 && yn < n && grid[xn][yn] != 0) {
                dfs(grid, xn, yn, value + grid[xn][yn]);
            }
        }
        grid[x][y] = temp;
    }
}
