import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        CycleInDirectedGraph cycleInDirectedGraph = new CycleInDirectedGraph();
        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Example 1: " + cycleInDirectedGraph.canFinish(numCourses1, prerequisites1)); // Output: true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Example 2: " + cycleInDirectedGraph.canFinish(numCourses2, prerequisites2)); // Output: false

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for (int[] pre : prerequisites) {
            if (!graph.containsKey(pre[0])) {
                graph.put(pre[0], new ArrayList<>());
            }
            graph.get(pre[0]).add(pre[1]);
        }

        boolean[] isVisited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!isVisited[i]){
                if(dfs(graph, i, isVisited, recStack)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, List<Integer>> graph, int node, boolean[] isVisited, boolean[] recStack){
        if(recStack[node]) return true;

        if(isVisited[node]) return false;

        recStack[node] = true;
        isVisited[node] = true;


        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (dfs(graph, neighbor, isVisited, recStack)) {
                    return true; // Return true if a cycle is detected in the neighbor
                }
            }
        }
        recStack[node] = false;
        return false;
    }
}
