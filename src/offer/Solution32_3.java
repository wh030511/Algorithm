package offer;

import java.util.*;

/**
 * @Author WuHao
 * @Create 2020-08-10 18:36
 *
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution32_3 {
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
        // 奇数行逆序
        for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
