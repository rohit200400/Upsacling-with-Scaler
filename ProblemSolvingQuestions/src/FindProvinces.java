public class FindProvinces {
    public static void main(String[] args) {

    }

    public static void dfs(int[][] isConnected, int city, int[] visitedCity) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && visitedCity[i] != 1) {
                visitedCity[i] = 1;
                dfs(isConnected, i, visitedCity);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visitedCity = new int[isConnected.length];
        int proCount = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visitedCity[i] != 1) {
                proCount++;
                visitedCity[i] = 1;
                dfs(isConnected, i, visitedCity);
            }
        }
        return proCount;
    }
}
