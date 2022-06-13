package Trees;

public class Diameter_of_a_Binary_Tree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode cur) {
        if (cur == null)
            return 0;

        int left = dfs(cur.left) + 1;
        int right = dfs(cur.right) + 1;

        diameter = diameter > (left + right - 2) ? diameter : (left + right - 2);

        return left > right ? left : right;
    }
}
