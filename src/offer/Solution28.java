package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-09-21:43
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Solution28 {
    @Test
    public void test() {
        TreeNode tree = ConstructTree.construct(new int[]{1, 2, 2, 6, 4, 4, 3});
        boolean res = isSymmetric(tree);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        return sameTree(constructTree(root), mirrorTree(root));
    }

    // 构造一个相同的tree
    private TreeNode constructTree(TreeNode root) {
        if (root == null) return null;

        TreeNode res = new TreeNode(root.val);
        res.left = constructTree(root.left);
        res.right = constructTree(root.right);
        return res;
    }

    private boolean sameTree(TreeNode treeA, TreeNode treeB) {
        if (treeA == null && treeB == null) return true;
        if (treeA == null || treeB == null || treeA.val != treeB.val) return false;
        return sameTree(treeA.left, treeB.left) && sameTree(treeA.right, treeB.right);
    }


    // 镜像树
    private TreeNode mirrorTree(TreeNode tree) {
        if (tree == null) return null;
        TreeNode le = tree.left;
        tree.left = mirrorTree(tree.right);
        tree.right = mirrorTree(le);

        return tree;
    }


    // 复制一下大神的解法, tql
    public boolean isSymmetric_update(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
