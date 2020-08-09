package offer;

import com.sun.xml.internal.stream.events.AttributeImpl;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author WuHao
 * @Create 2020-08-09-19:10
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值
 */
public class Solution26 {
    @Test
    public void test() {
        TreeNode A = ConstructTree.construct(new int[]{1, 2, 3, 4});
        TreeNode B = ConstructTree.construct(new int[]{3});
        boolean res = isSubStructure(A, B);
        System.out.println(res);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSubHelper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    // 前序遍历
    private String preOrder (TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.poll();
            str.append(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return str.toString();
    }

    private boolean isSubHelper(TreeNode tree, TreeNode subTree) {
        if (subTree == null) return true; // 递归出口1
        if (tree == null || tree.val != subTree.val) return false; // 递归出口2

        return isSubHelper(tree.left, subTree.left) && isSubHelper(tree.right, subTree.right);
    }

}
