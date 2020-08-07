package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WuHao
 * @create 2020-04-10-10:03
 */
public class Solution114 {

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = new TreeNode(6);
        left.right = new TreeNode(2);
        right.left = new TreeNode(0);
        right.right = new TreeNode(8);
        TreeNode lright = left.right;
        lright.left = new TreeNode(7);
        lright.right = new TreeNode(4);

        flatten(root);
//        while(flatten != null){
//            System.out.println(flatten.val);
//            flatten = flatten.right;
//        }
    }

    public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }


        TreeNode tmp = root;
        list.poll();
        while(!list.isEmpty()){
            tmp.left = null;
            tmp.right = list.poll();
            tmp = tmp.right;
        }

        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }


    }
}
