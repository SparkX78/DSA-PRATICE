import java.util.*;
public class MaxBinary {
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
    public static TreeNode constructMax(int[] nums){
        if(nums == null){
            return null;
        }
        return build(nums, 0, nums.length-1 );

    }
    private static TreeNode build(int[] nums, int start, int end){
        if(start > end) return null;
        int idMax = start;
         
        for(int i = start+1; i <= end; i++ ){
            if(nums[i] > nums[idMax]){
                idMax = i;
            }
            
        }
        TreeNode root = new TreeNode(nums[idMax]);
        root.left = build(nums, start, idMax-1);
        root.right = build(nums, idMax+1, end);
        return root;
        
    }
    public static void printTree(TreeNode root){
        if(root == null) return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] nums = {3, 2, 1, 6, 0, 5};
        printTree(constructMax(nums));

    }
}
