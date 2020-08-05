package exam.common;

import org.junit.Test;

import java.util.*;

/**
 * 中序遍历实现
 * @author WuHao
 * @create 2020-03-22-18:54
 */
public class inorderTraversal {

    @Test
    public  void test(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] nums = str.split(",");
            TreeNode[] nodeArray = new TreeNode[nums.length];
            for (int i = 0; i < nums.length; i++){
                if (!"null".equals(nums[i])){
                    nodeArray[i] = new TreeNode(Integer.parseInt(nums[i]));
                }else{
                    nodeArray[i] = null;
                }
            }
            TreeNode root = nodeArray[0];
            getTree(nodeArray, root, 0);
            List<Integer> res = inorderTraversal2(root);
            for (Integer re : res) {
                System.out.println(re);
            }
        }
    }

    private void getTree(TreeNode[] trees , TreeNode root,int index){
        if (2*index+1 < trees.length){
            root.left = trees[2*index + 1];
            getTree(trees, root.left, 2*index+1);
        }
        if (2*index+2 < trees.length){
            root.right = trees[2*index+2];
            getTree(trees, root.right, 2*index+2);
        }
        return ;
    }

    // 递归实现
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        Stack<Integer> res = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.poll();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

}
