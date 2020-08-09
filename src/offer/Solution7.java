package offer;

import java.util.HashMap;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:51
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class Solution7 {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }

        return recure(0,0,inorder.length - 1);

    }

    TreeNode recure(int rootIndex,int inLeft,int inRight){
        if(inLeft > inRight) return null;
        int i = map.get(po[rootIndex]);
        TreeNode root = new TreeNode(po[rootIndex]);
        root.left = recure(rootIndex + 1,inLeft,i - 1);
        root.right = recure(rootIndex + i - inLeft + 1,i + 1,inRight);
        return root;
    }
}
