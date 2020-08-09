package offer;

import sun.plugin.javascript.navig.Link;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author WuHao
 * @Create 2020-08-09-21:31
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode le = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(le);
        return root;
    }
}
