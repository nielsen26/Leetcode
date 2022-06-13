package Trees;

public class Balanced_Binary_Tree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        dfs(root);

        return isBalanced;
    }

    private int dfs(TreeNode cur) {
        if (cur == null)
            return -1;

        int left = dfs(cur.left) + 1;
        int right = dfs(cur.right) + 1;

        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return left > right ? left : right;
    }
}
