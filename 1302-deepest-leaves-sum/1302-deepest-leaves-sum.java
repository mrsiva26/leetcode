/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int deepest = deepestLevel(root, 0);
        
        return deepestLevelSum(root, 1, deepest);
    }
    
    public int deepestLevelSum(TreeNode root, int currentLevel, int deepest) {
        
        if (root == null)
            return 0;
        
        if (currentLevel == deepest)
            return root.val;
        
        return deepestLevelSum(root.left,  currentLevel+1, deepest) +
               deepestLevelSum(root.right, currentLevel+1, deepest);
        
    }
    
    public int deepestLevel(TreeNode root, int currentLevel) {
        
        if (root == null)
            return currentLevel;
        
        return Math.max(deepestLevel(root.left, currentLevel+1),
                        deepestLevel(root.right, currentLevel+1));
    }
}