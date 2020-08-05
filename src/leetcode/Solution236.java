package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 二叉树的最近公共祖先
 * @author WuHao
 * @create 2020-04-09-10:27
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;


        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp.left == p || tmp.right == p){
                p = tmp;
                break;
            }
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null){
                stack.push(tmp.left);
            }
        }
        stack.clear();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp.left == q || tmp.right == q){
                q = tmp;
                break;
            }
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null){
                stack.push(tmp.left);
            }
        }

        return lowestCommonAncestor(root , p , q);
    }
}
