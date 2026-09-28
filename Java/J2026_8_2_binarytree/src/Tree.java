//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: wzs
// * Date: 2026-08-02
// * Time: 13:09
// */
//public class Tree {
//    static class TreeNode{
//        public char val;
//        public TreeNode left;
//        public TreeNode right;
//
//        public TreeNode(char val){
//            this.val=val;
//        }
//    }
//
//    public TreeNode createTree(){
//        TreeNode A=new TreeNode('A');
//        TreeNode B=new TreeNode('B');
//        TreeNode C=new TreeNode('C');
//        TreeNode D=new TreeNode('D');
//        TreeNode E=new TreeNode('E');
//        TreeNode F=new TreeNode('F');
//        TreeNode G=new TreeNode('G');
//        TreeNode H=new TreeNode('H');
//
//        A.left=B;
//        A.right=C;
//        B.left=D;
//        B.right=E;
//        D.left=H;
//        C.left=F;
//        C.right=G;
//
//        return A;
//    }
//
//    //前序
//    public void preOrder(TreeNode root){
//        if (root==null){
//            return;
//        }
//        System.out.print(root.val+" ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }
//
//    List<Character> list=new ArrayList<>();
//    public List<Character> preorderTraversal(TreeNode root) {
//        if (root==null){
//            return list;
//        }
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return list;
//    }
//
//    public List<Character> preorderTraversal1(TreeNode root) {
//        List<Character> list=new ArrayList<>();
//        if (root==null){
//            return list;
//        }
//        list.add(root.val);
//        List<Character> Left = preorderTraversal(root.left);
//        list.addAll(Left);
//        List<Character> Right = preorderTraversal(root.right);
//        list.addAll(Right);
//        return list;
//    }
//
//    //中序
//    public void inOrder(TreeNode root){
//        if (root == null){
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.val+" ");
//        inOrder(root.right);
//    }
//    //后序
//    public void postOrder(TreeNode root){
//        if (root == null){
//            return;
//        }
//        inOrder(root.left);
//        inOrder(root.right);
//        System.out.print(root.val+" ");
//    }
//
//    public static int nodeSize=0;
//    public int size(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        nodeSize++;
//        size(root.left);
//        size((root.right));
//        return nodeSize;
//    }
//
//    public int size1(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        return size1(root.left)+size1(root.right)+1;
//    }
//
//    public static int size=0;
//    public int getLeafNodeCount(TreeNode root){
//        if (root==null){
//            return 0;
//        }
//        if(root.right==null&&root.left==null){
//            size++;
//        }
//        getLeafNodeCount(root.left);
//        getLeafNodeCount(root.right);
//        return size;
//    }
//
//    public int getLeafNodeCount1(TreeNode root){
//        if (root==null){
//            return 0;
//        }
//        if(root.right==null&&root.left==null){
//            return 1;
//        }
//        return getLeafNodeCount1(root.left)+ getLeafNodeCount1(root.right);
//    }
//
//    public int getKLevelNodeCount(TreeNode root,int k){
//        if (root == null){
//            return 0;
//        }
//        if(k==1){
//            return 1;
//        }
//        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
//    }
//
//    public static int size1=0;
//    public int getKLevelNodeCount1(TreeNode root,int k){
//        if (root == null){
//            return 0;
//        }
//        if(k==1){
//            size1++;
//        }
//        getKLevelNodeCount1(root.left,k-1);
//        getKLevelNodeCount1(root.right,k-1);
//        return size1;
//    }
//
//    //获取高度
//    public int getHeight(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        int leftHeight=getHeight(root.left);
//        int rightHeight=getHeight(root.right);
//        return Math.max(leftHeight,rightHeight)+1;
//    }
//
//    public TreeNode findVal(TreeNode root, char val){
//        if (root==null){
//            return null;
//        }
//        if(root.val==val){
//            return root;
//        }
//        TreeNode leftT = findVal(root.left,val);
//        if (leftT!=null){
//            return leftT;
//        }
//        TreeNode rightT = findVal(root.right,val);
//        if (rightT!=null){
//            return rightT;
//        }
//        return null;
//    }
//}
