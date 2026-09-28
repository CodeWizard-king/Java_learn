import java.lang.invoke.VarHandle;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-03
 * Time: 9:20
 */
public class BinaryTree {

    static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }
    }


    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {

        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderNor(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            cur=top.right;
        }
    }

    //前序非递归遍历实现
    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        list.add(root.val);

        List<Character> Left = preorderTraversal(root.left);
        list.addAll(Left);

        List<Character> Right = preorderTraversal(root.right);
        list.addAll(Right);

        return list;
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public void inOrderNor(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            System.out.print(top.val+" ");
            cur=top.right;
        }
    }
    //中序非递归遍历实现
    public List<Character> inorderTraversal(TreeNode root) {
        List<Character> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        List<Character> Left = inorderTraversal(root.left);
        list.addAll(Left);

        list.add(root.val);

        List<Character> Right = inorderTraversal(root.right);
        list.addAll(Right);
        return list;
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public void postOrderNor(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;

        while(cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.peek();
            if (top.right == null || top.right == prev){
                System.out.print(top.val+" ");
                stack.pop();
                prev=top;
            }else {
                cur=top.right;
            }
        }
    }

//后序非递归遍历实现
/*
解题思路：后序非递归遍历需要借助栈
1. 空树，直接返回
2. 如果树非空：从根节点位置开始遍历，但此时根节点不能遍历，因为后序遍历规则：左子树、右子树、根节点
a. 沿着根节点一直往左走，将所经过路径中的节点依次入栈
b. 取栈顶元素，该元素取到后，其左子树要么为空，要么已经遍历，
但是此时该节点不能遍历，除非其右子树不存在或者其右子树已经遍历，才可以遍历该节点
如果该节点右子树没有遍历，将其右子树作为一棵新的二叉树遍历，继续a
具体实现：参考代码，学生自己动手画图理解
*/
    public List<Character> postorderTraversal(TreeNode root) {
        // 如果是空树，直接返回
        List<Character> ret = new ArrayList<>();
        if(null == root){
            return ret;
        }
        TreeNode cur = root;
        TreeNode prev = null;  // 记录刚刚过节点的前一个
        Stack<TreeNode> s = new Stack<>();
        while(null != cur || !s.empty()){
            // 找以cur为根的最左侧节点，并保存其所经路径中所有的节点
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            // 此处不能直接遍历根，根节点的右子树遍历完成之后才可以遍历根
            TreeNode top = s.peek();
            // 如果根节点的右子树是空，或者右子树已经遍历过了
            if(top.right == null || top.right == prev){
                ret.add(top.val);
                prev = top;
                s.pop();
            }
            else
            {
                // 如果top的右子树存在，并且没有遍历过，将其右子树当成新树遍历
                cur = top.right;
            }
        }
        return ret;
    }

    /**
     * 获取树中节点的个数：遍历思路
     */
    public static int nodeSize;
    public void size(TreeNode root) {
        if (root==null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    public int size2(TreeNode root) {
        if (root==null){
            return 0;
        }
        return size2(root.left)+size2(root.right)+1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    public void getLeafNodeCount1(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    public int getLeafNodeCount2(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    public int getHeight(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }


    // 检测值为value的元素是否存在
    public TreeNode findVal(TreeNode root, char val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        TreeNode leftT = findVal(root.left,val);
        if (leftT!=null){
            return leftT;
        }
        TreeNode rightT = findVal(root.right,val);
        if (rightT!=null){
            return rightT;
        }
        return null;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }



    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while (!queue.isEmpty()){
            TreeNode peek=queue.peek();
            if (peek!=null){
                return false;
            }
            queue.poll();
        }
        return true;
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null || p!=null&&q==null){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }


    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric1(root.left,root.right);
    }

    public boolean isSymmetric1(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree==null&&rightTree!=null||leftTree!=null&&rightTree==null){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        if(leftTree.val!=rightTree.val){
            return false;
        }

        return isSymmetric1(leftTree.left,rightTree.right)
                && isSymmetric1(leftTree.right,rightTree.left);
    }

    //

}


