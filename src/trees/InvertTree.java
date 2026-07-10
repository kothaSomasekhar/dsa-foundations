package trees;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
public class InvertTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

    TreeNode(int data){
        this.data=data;
    }}
    public TreeNode invertTree(TreeNode root){
        if(root == null)return root;
        TreeNode swapleft=invertTree(root.left);
        TreeNode swapright=invertTree(root.right);
        root.left=swapright;
        root.right=swapleft;
        return root;
    }
    public void printlevelorder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode>queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null) queue.offer(curr.left);
            if(curr.right!=null) queue.offer(curr.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        InvertTree it = new InvertTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Original Level Order: ");
        it.printlevelorder(root);

        TreeNode invertedRoot = it.invertTree(root);

        System.out.print("Inverted Level Order: ");
        it.printlevelorder(invertedRoot);
    }
}
