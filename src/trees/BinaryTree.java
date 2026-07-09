package trees;

public class BinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    public void PreOrder(TreeNode root){
        if(root==null)return;
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public void InOrder(TreeNode root){
        if(root==null)return;
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }
    public void PostOrder(TreeNode root){
        if(root ==null)return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" ");
    }public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Manually assembling a sample tree structure:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Pre-Order Traversal: ");
        tree.PreOrder(root); // Expected: 1 2 4 5 3
        System.out.println();

        System.out.print("In-Order Traversal: ");
        tree.InOrder(root);  // Expected: 4 2 5 1 3
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        tree.PostOrder(root); // Expected: 4 5 2 3 1
        System.out.println();
    }
}
