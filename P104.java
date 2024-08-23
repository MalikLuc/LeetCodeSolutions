public class P104 {
    public int maxDepth(TreeNode root) {
        // base case
        if(root == null) return 0;
        // recursively call the left & right node if they are not null
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // backtrack and take the deeper path
        return 1 + Math.max(l,r);
    }
}
