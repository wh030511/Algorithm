package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-10 18:30
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>(); // 作为结果

        Deque<TreeNode> queueA = new LinkedList<>();
        Deque<TreeNode> queueB = new LinkedList<>();
        queueA.offer(root);

        List<Integer> list;
        while (!queueA.isEmpty()) {
            list = new ArrayList<>();
            while (!queueA.isEmpty()) {
                TreeNode node = queueA.poll();
                list.add(node.val);
                if (node.left != null) queueB.offer(node.left);
                if (node.right != null) queueB.offer(node.right);
            }
            res.add(list);

            list = new ArrayList<>();
            while (!queueB.isEmpty()) {
                TreeNode node = queueB.poll();
                list.add(node.val);
                if (node.left != null) queueA.offer(node.left);
                if (node.right != null) queueA.offer(node.right);
            }
            if (list.size() != 0) {
                res.add(list);
            }
        }

        return res;
    }
}
