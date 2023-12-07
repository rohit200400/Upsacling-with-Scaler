import java.util.HashMap;

public class BiggestTreeInForest {
    public static void main(String[] args) {
        BiggestTreeInForest treeInForest = new BiggestTreeInForest();
        // Create a forest represented by a HashMap where the key is the child node and the value is the parent node
        HashMap<Integer, Integer> forestMap = new HashMap<>();

        // Populate the forest (you can customize this based on your specific scenario)
        forestMap.put(2, 1);
        forestMap.put(3, 2);
        forestMap.put(8, 6);
        forestMap.put(5, 4);
        forestMap.put(7, 6);
        forestMap.put(6, 4);

        // Find and print the root node of the biggest tree in the forest
        int biggestTreeRoot = treeInForest.findBiggestTreeRoot(forestMap);
        System.out.println("Root of the biggest tree: " + biggestTreeRoot);
    }

    private int findBiggestTreeRoot(HashMap<Integer, Integer> forestMap) {
        HashMap<Integer, Integer> treeSize = new HashMap<>();
        for (Integer child : forestMap.keySet()
             ) {
            int root = forestMap.get(child);
            while(forestMap.containsKey(root) && forestMap.get(root) != root){
                root = forestMap.get(root);
            }
            treeSize.put(root, treeSize.getOrDefault(root, 0)+1);
        }
        int maxSize = 0;
        int biggestRoot = -1;
        for (Integer root: treeSize.keySet()
             ) {
            if(treeSize.get(root) > maxSize){
                maxSize = treeSize.get(root);
                biggestRoot = root;
            }
        }
        return biggestRoot;
    }
}
