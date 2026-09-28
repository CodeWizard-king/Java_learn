/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-15
 * Time: 9:38
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(9);
        bst.insert(3);
        bst.insert(18);

        BinarySearchTree.TreeNode ret = bst.search(15);
        System.out.println(ret.val);

    }


}
