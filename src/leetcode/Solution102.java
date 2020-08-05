package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author WuHao
 * @create 2020-05-26-8:38
 */
public class Solution102 {



    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queueA = new ArrayDeque<>();
        Deque<TreeNode> queueB = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queueA.add(root);

        boolean flag = true;
        while(flag){

            List<Integer> itemA = new ArrayList<>();
            List<Integer> itemB = new ArrayList<>();

            while(queueA.size() != 0){
                flag = false;
                TreeNode re = queueA.remove();
                itemA.add(re.val);
                if (re.left != null) queueB.add(re.left);
                if (re.right != null) queueB.add(re.right);
            }

            if (!flag){
                res.add(itemA);
                flag = true;
            }


            while(queueB.size() != 0){
                flag = false;
                TreeNode re = queueB.remove();
                itemB.add(re.val);
                if (re.left != null) queueA.add(re.left);
                if (re.right != null) queueA.add(re.right);
            }

            if (!flag){
                res.add(itemB);
            }

            if (flag) break;

            flag = true;

        }

        return res;
    }
}
