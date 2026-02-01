import java.util.*;
public class RightTree {
    


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
    public static List<Integer> rightTree(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int  size = queue.size();
            int lastValue = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                lastValue = node.val;
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            result.add(lastValue);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int left_value = sc.nextInt();
        int right_value = sc.nextInt();
        int left_left_value = sc.nextInt();
        int left_right_value = sc.nextInt();
        TreeNode root = new TreeNode(value);
        root.left = new TreeNode(left_value);
        root.right = new TreeNode(right_value);
        root.left.left = new TreeNode(left_left_value);
        root.left.right = new TreeNode(left_right_value);
        System.out.println(rightTree(root));
        sc.close();
    }
    
}

