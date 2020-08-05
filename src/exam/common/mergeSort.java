package exam.common;

import org.junit.Test;

import java.util.Random;

/**
 * 归并排序
 * @author WuHao
 * @create 2020-03-22-9:43
 */
public class mergeSort{

    @Test
    public void test(){
        Random ran = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = ran.nextInt(100);
        }
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int l, int r){
        if (l == r) return ;

        int mi = (l + r) >> 1;
        sort(arr, l, mi);
        sort(arr, mi+1, r);
        merge(arr, l, mi, r);
    }

    public static void merge(int[] arr, int l, int mi, int r){
        int[] tmp = new int[r-l+1]; // 存放排序后的数组
        int i = 0;
        int p1 = l;
        int p2 = mi + 1;
        // 比较左右部分的元素 将小的元素放到tmp中
        while(p1 <= mi && p2 <= r){
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 将剩下的元素填入tmp中
        while(p1 <= mi){
            tmp[i++] = arr[p1++];
        }
        while(p2 <= r){
            tmp[i++] = arr[p2++];
        }
        // 将tmp中数据放入原数组
        for (int k = 0;k < tmp.length; k++){
            arr[l+k] = tmp[k];
        }
    }

}
