package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-10 20:44
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 */
public class Solution34 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> queue = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) return;

        queue.offer(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(queue));
        }

        recur(root.left,target);
        recur(root.right, target);

        queue.removeLast();
    }

}
