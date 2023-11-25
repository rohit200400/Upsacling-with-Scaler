/*You are given an m x n grid grid of values 0, 1, or 2, where:

each 0 marks an empty land that you can pass by freely,
each 1 marks a building that you cannot pass through, and
each 2 marks an obstacle that you cannot pass through.
You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.

Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.


The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
So return 7.*/
public class SortestDistanceFromBuildings {
    static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        int[][] inp = new int[][] { {1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0} };
        System.out.println(shortestDistance(inp));

    }
    public static int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int visited = -1;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    calculateDistance(i,j,dist,grid,visited,0);
                    visited--;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(dist[i][j] > 0){
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        return minDist != Integer.MAX_VALUE ? minDist : -1;
    }

    private static void calculateDistance(int i, int j, int[][] dist, int[][] grid, int visited, int distance) {
        if(grid[i][j] == visited && dist[i][j] > 0) {
            dist[i][j] = Math.min(dist[i][j], distance);
            return;
        }
       if(grid[i][j] != 1){
           grid[i][j] = visited;
           dist[i][j] += distance;
       }
        for(int[] dir: directions){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<grid.length && y< grid[0].length && grid[x][y] <= 0){
                calculateDistance(x,y,dist,grid,visited,distance+1);
            }
        }

    }

}
