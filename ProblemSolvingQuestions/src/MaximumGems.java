class MaximumGems {
    static int SUM = 0;

    public static int optimalPath(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        helper(grid, 0, rows - 1, 0);
        return SUM;
    }

    public static void helper(int[][] grid, int x, int y, int sum) {
        if (x == 0 && y == 0) {
            SUM += sum + grid[x][y];
            return;
        }

        if (x - 1 >= 0) {
            helper(grid, x - 1, y, sum + grid[x][y]);
        }

        if (y - 1 >= 0) {
            helper(grid, x, y - 1, sum + grid[x][y]);
        }
    }

    public static boolean doTestsPass() {
        boolean result = true;
        result &= optimalPath(new int[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;
        return result;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
