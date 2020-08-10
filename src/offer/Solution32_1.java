package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-10 15:39
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};

        Deque<TreeNode> queueA = new LinkedList<>();
        Deque<TreeNode> queueB = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queueA.offer(root);

        while (!queueA.isEmpty()) {
            while (!queueA.isEmpty()) {
                TreeNode node = queueA.poll();
                list.add(node.val);
                if (node.left != null) queueB.offer(node.left);
                if (node.right != null) queueB.offer(node.right);
            }

            while (!queueB.isEmpty()) {
                TreeNode node = queueB.poll();
                list.add(node.val);
                if (node.left != null) queueA.offer(node.left);
                if (node.right != null) queueA.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
