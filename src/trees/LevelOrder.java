package trees;
import java.util.*;

public class LevelOrder {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
        }}
        public List<List<Integer>> levelorder(TreeNode root){
            List<List<Integer>> result=new ArrayList<>();
            if(root ==null) return result;

            Queue<TreeNode> queue=new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelsize=queue.size();
                List<Integer> currentlevel=new ArrayList<>();
                for(int i=0;i<levelsize;i++){
                    TreeNode val=queue.poll();
                    currentlevel.add(val.data);
                    if(val.left!=null){
                        queue.offer(val.left);
                    }
                    if(val.right!=null){
                        queue.offer(val.right);
                    }

                }result.add(currentlevel);
            }return result;
        }
    public static void main(String[] args) {
        LevelOrder lo = new LevelOrder();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Level Order: " + lo.levelorder(root));
    }

}
