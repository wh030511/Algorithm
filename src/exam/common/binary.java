package exam.exam.common;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-03-22-7:33
 */
public class binary {
    @Test
    public void test(){
        int[] arr = {1,3};
        int res = binarySearch2(arr, 3, 0, arr.length);
        System.out.println(res);

    }

    private int binarySearchR(int[] arr , int lo , int hi , int target){

        if (lo > hi) return -1;

        int mi = (lo + hi) >> 1;
        if (target < arr[mi]) return binarySearchR(arr, lo, mi - 1, target);
        else if (arr[mi] < target) return binarySearchR(arr, mi + 1, hi, target);
        else return mi;
    }

    // 基础的二分查找 复杂度O（1.5log（n）） 左右分支转向代价不平衡
    private int binarySearch(int[] arr, int target, int lo, int hi){
        while(lo < hi){ // 数组存在
            int mi = (lo + hi) >> 1;
            if (target < arr[mi]) hi = mi; // 左边查找
            else if (arr[mi] < target) lo = mi + 1; // 右边查找
            else return mi; // 命中
        }
        return -1;
    }

    // 最好情况下更坏，最坏情况下更好，整体性能更加稳定
    private int binarySearch2(int[] arr, int target, int lo, int hi){
        while(1 < hi - lo){ // 有效区间宽度为1时算法停止
            int mi = (lo + hi) >> 1;
            if (target < arr[mi]) hi = mi;
            else lo = mi;
        }// 出口时hi = lo + 1
        return (target == arr[lo]) ? lo:-1;
    }

    private int binarySearch21(int[] arr, int target,int lo, int hi){
        while(1 < hi - lo){
            int mi = (lo + hi) >> 1;
            if (target < arr[mi]) hi = mi;
            else lo = mi;
        }
        return (target == arr[lo]) ? lo:-1;
    }

    // 当有多个满足条件的数时，严格返回满足条件的最后一个数，返回不大于target的最后一个数
    private int binarySearch3(int[] arr, int target, int lo, int hi){
        while(lo < hi){ // 数组存在
            int mi = (lo + hi) >> 1;
            if (target < arr[mi]) hi = mi; // 左边查找
            else lo = mi + 1; // 右边查找 后面的数一定严格大于target
        }
        return --lo;
    }
}
