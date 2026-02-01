public class HouseRobber3 {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.right = null;
            this.left = null;
            this.val = val;
        }
    }
    public static int maxRobbery(TreeNode root){
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }
    private static int[] travel(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left_root_choice = travel(root.left);
        int[] right_root_choice = travel(root.right);
        int[] options = new int[2];

        options[0] = root.val + left_root_choice[1] + right_root_choice[1];
        options[1] = Math.max(left_root_choice[0], left_root_choice[1]) + Math.max(right_root_choice[1], right_root_choice[0]);

        return options;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        
        System.out.println(maxRobbery(root));
    }
}
