package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-09-20:16
 *
 * 通过数组构建一棵树
 */
public class ConstructTree {
    public static TreeNode construct(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode res = new TreeNode(nums[0]);
        TreeNode curr = res;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(curr);

        // 开始时
        int lineNodeNun = 2; // 当前行节点个数
        int startIndex = 1; // 开始位置
        int restLength = nums.length - 1; // 数组剩余个数

        while (restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNun; i += 2) {
                if (i == nums.length) return res;
                curr = nodeQueue.poll();
                curr.left = new TreeNode(nums[i]);
                nodeQueue.offer(curr.left);

                if (i+1 == nums.length) return res;
                curr.right = new TreeNode(nums[i+1]);
                nodeQueue.offer(curr.right);
            }

            startIndex += lineNodeNun;
            restLength -= lineNodeNun;
            lineNodeNun = nodeQueue.size() * 2;
        }

        return res;
    }
}
