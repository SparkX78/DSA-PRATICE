import java.util.*;
public class SymmetryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean symmetric(TreeNode root){
        if(root == null)return true;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode leftNode = left.poll();
            TreeNode rightNode = right.poll();
            if(leftNode == null && rightNode == null)return true;
            if(leftNode == null || rightNode == null)return false;
            if(rightNode.val != leftNode.val)return false;

            left.add(leftNode.left);
            left.add(leftNode.right);
            right.add(rightNode.right);
            right.add(rightNode.left);
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left  = new TreeNode(4); 
        root.right.right  = new TreeNode(3); 
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(symmetric(root));
    }
}
