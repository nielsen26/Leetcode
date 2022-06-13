package Trees;

public class Lowest_Common_Ancestor_of_a_BST {
    private boolean found = false;
    private int pval;
    private int qval;
    private TreeNode ret;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val)
            return root;
        ret = root;
        pval = p.val;
        qval = q.val;

        findAncestor(root);

        return ret;
    }

    private boolean findAncestor(TreeNode cur) {
        if (found)
            return false;
        if (cur == null)
            return false;

        boolean left = findAncestor(cur.left);
        boolean right = findAncestor(cur.right);

        if (cur.val == pval || cur.val == qval || (left && right)) {
            if (left || right) {
                found = true;
                ret = cur;
                return false;
            }
            return true;
        }

        if (left || right)
            return true;

        return false;
    }
}
