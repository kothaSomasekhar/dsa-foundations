package trees;

public class TreeDepth {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
        }
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int depthleft=maxDepth(root.left);
        int depthright=maxDepth(root.right);

        return 1+Math.max(depthleft,depthright);
    }
    public static void main(String[] args) {
        TreeDepth td = new TreeDepth();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);



        // Expected Output: 3
        System.out.println("Maximum Depth: " + td.maxDepth(root));
    }
}
