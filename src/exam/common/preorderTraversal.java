package exam.common;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归实现前序遍历
 * @author WuHao
 * @create 2020-03-22-18:35
 */
public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) return res;

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode tree = stack.pollLast();
            res.add(tree.val);
            if (tree.right != null){
                stack.add(tree.right);
            }
            if (tree.left != null){
                stack.add(tree.left);
            }
        }
        return res;
    }

    public void preorder1(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.removeLast();
            System.out.println(temp.val);
            if (temp.right != null){
                stack.addLast(temp.right);
            }
            if (temp.left != null){
                stack.addLast(temp.left);
            }
        }
    }

    public List<Integer> preorder(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) return null;

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode tree = stack.pollLast();
            res.add(tree.val);
            if (tree.right != null){
                stack.add(tree.right);
            }
            if (tree.left != null){
                stack.add(tree.left);
            }
        }
        return res;
    }
}

