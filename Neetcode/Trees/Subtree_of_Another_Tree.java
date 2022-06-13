package Trees;

public class Subtree_of_Another_Tree {
    private boolean true_sub = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        checkTree(root, subRoot);

        return true_sub;
    }

    private boolean validate(TreeNode cur, TreeNode subcur) {
        if (cur == null && subcur == null)
            return true;

        if (cur == null || subcur == null)
            return false;

        if (cur.val != subcur.val)
            return false;

        return validate(cur.left, subcur.left) && validate(cur.right, subcur.right);
    }

    private void checkTree(TreeNode root, TreeNode sub) {
        if (true_sub)
            return;

        if (root == null)
            return;

        if (root.val == sub.val)
            true_sub = validate(root, sub);

        if (!true_sub) {
            checkTree(root.left, sub);
            checkTree(root.right, sub);
        }
    }
}
