import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodesAtDistance {
    public static void main(String[] args) {
        // Example Tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        NodesAtDistance nodesAtDistance = new NodesAtDistance();
        NodesAtDistance.TreeNode root = nodesAtDistance.new TreeNode(1);
        root.left = nodesAtDistance.new TreeNode(2);
        root.right = nodesAtDistance.new TreeNode(3);
        root.left.left = nodesAtDistance.new TreeNode(4);
        root.left.right = nodesAtDistance.new TreeNode(5);
        root.right.right = nodesAtDistance.new TreeNode(6);

        // Case 1: Target node is 2, find nodes at distance 2
        int distance1 = 2;
        System.out.println("Case 1: Nodes at distance " + distance1 + " from target node 2:");
        nodesAtDistance.nodeAtKDistance(root, distance1);

        // Case 2: Target node is 4, find nodes at distance 1
        NodesAtDistance.TreeNode root2 = nodesAtDistance.new TreeNode(4);
        root2.left = nodesAtDistance.new TreeNode(2);
        root2.right = nodesAtDistance.new TreeNode(5);
        int distance2 = 1;
        System.out.println("\nCase 2: Nodes at distance " + distance2 + " from target node 4:");
        nodesAtDistance.nodeAtKDistance(root2, distance2);

        // Case 3: Target node is 1, find nodes at distance 3
        int distance3 = 3;
        System.out.println("\nCase 3: Nodes at distance " + distance3 + " from target node 1:");
        nodesAtDistance.nodeAtKDistance(root, distance3);
    }
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        Integer value;
        TreeNode(Integer value){
            left = right = null;
            this.value = value;
        }
    }
    public void nodeAtKDistance(TreeNode root, Integer dist){
        if(root==null || (root.left == null && root.right == null && dist > 0)){
            System.out.println("wrong input");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode currNode;
        int currDist = 0;
        while(!queue.isEmpty()){
            currNode = queue.poll();
            if(currDist > dist) return;
            if(currNode == null) {
                queue.add(null);
                currDist++;
            }else{
                if(currDist == dist){
                    System.out.println("Node " + currNode.value + " is at distance " + dist);
                }
                else{
                    if(currNode.left != null){
                        queue.add(currNode.left);
                    }
                    if(currNode.right != null){
                        queue.add(currNode.right);
                    }
                }
            }
        }
    }
}
