/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-02
 * Time: 13:09
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        BinaryTree.TreeNode root=binaryTree.createTree();

        binaryTree.invertTree(root);
        //遍历
        System.out.println("=========前序=========");
        binaryTree.preOrder(root);
        System.out.println();
        System.out.println(binaryTree.preorderTraversal(root));
        binaryTree.preOrderNor(root);
        System.out.println();

        System.out.println("=========中序=========");
        binaryTree.inOrder(root);
        System.out.println();
        System.out.println(binaryTree.inorderTraversal(root));
        binaryTree.inOrderNor(root);
        System.out.println();

        System.out.println("=========后序=========");
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println(binaryTree.postorderTraversal(root));
        binaryTree.postOrderNor(root);
        System.out.println();

        System.out.println("=========层序=========");
        binaryTree.levelOrder(root);

        binaryTree.size(root);
        System.out.println("树中节点的个数(遍历思路):"+BinaryTree.nodeSize);
        System.out.println("树中节点的个数(子问题思路):"+binaryTree.size2(root));

        binaryTree.getLeafNodeCount1(root);
        System.out.println("叶子节点的个数(遍历思路):"+BinaryTree.leafSize);
        System.out.println("叶子节点的个数(子问题思路):"+binaryTree.getLeafNodeCount2(root));

        System.out.println("第K层节点的个数:"+binaryTree.getKLevelNodeCount(root, 2));

        System.out.println("二叉树的高度:"+binaryTree.getHeight(root));

        BinaryTree.TreeNode str=binaryTree.findVal(root,'D');
        System.out.println("val的元素是否存在:"+str.val);

        System.out.println("判断一棵树是不是完全二叉树"+binaryTree.isCompleteTree(root));

    }
}
