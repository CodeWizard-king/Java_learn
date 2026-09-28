/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-15
 * Time: 9:39
 */
public class BinarySearchTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode root;

    public void insert(int val){
        if (root == null){
            root = new TreeNode(val);
            return;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        TreeNode node = new TreeNode(val);

        while (cur != null){
            parent = cur;
            if (cur.val < val){
                cur = cur.right;
            }else if (cur.val > val){
                cur = cur.left;
            }else {
                //二叉搜索树不能有相同数字的节点
                return;
            }
        }
        if (parent.val < val){
            parent.right = node;
            return;
        }else {
            parent.left = node;
        }
    }

    public TreeNode search(int val){
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == val){
                return cur;
            } else if (cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public void remove(int key){
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if (cur.val < key){
                parent = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                removeNode(parent,cur);
                return;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur){
        if (cur.left == null && cur.right != null){

            if (cur == root){
                root = cur.right;
            }else if (parent.left == cur){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }

        } else if (cur.right == null && cur.left != null) {

            if (cur == root){
                root = cur.left;
            }else if (parent.left == cur){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }

        }else {

            TreeNode targetParent = cur;
            TreeNode target = cur.left;
            while (target != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target){
                targetParent.left = target.right;
            }else {
                targetParent.right =target.right;
            }

        }
    }
}
