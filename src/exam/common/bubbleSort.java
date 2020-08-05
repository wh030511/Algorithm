package exam.common;

import org.junit.Test;

import java.util.Random;

/**
 * @author WuHao
 * @create 2020-03-22-8:26
 */
public class bubbleSort {

    @Test
    public void test(){
        Random ran = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = ran.nextInt(100);
        }
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void bubbleSort1(int[] arr){
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return ;
    }

    // 某些情况下可以提前结束循环 最好情况O(n) 稳定的
    private void bubbleSort2(int[] arr, int n){
        for (boolean flag = false; flag = !flag; n--){
            for (int i = 1; i < n; i++){
                if (arr[i-1] > arr[i]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = false; // 还有可能无序
                }
            }
        }
    }

    private void bubbleSort11(int[] arr , int n){
        for (boolean flag = false; flag = !flag; n--){
            for (int i = 1; i < n; i++){
                if (arr[i-1] > arr[i]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = false;
                }
            }
        }
    }

    private void bubbleSort3(int[] arr){
        int tmp = 0;
        int lastExchanged = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++){
            boolean isSorted = true;
            for (int j = 0; j < sortBorder;j++){
                if (arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    lastExchanged = j;
                    isSorted = false;
                }
            }
            sortBorder = lastExchanged;
            if (isSorted){
                break;
            }
        }
    }

    private void bubbleSort(int[] arr){
        int lastExchanged = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++){
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    isSorted = false;
                    lastExchanged = j;
                }
            }
            sortBorder = lastExchanged;
            if (isSorted) break;
        }
    }

}

class Main{
    private void bubbleSortx(int[] arr, int n){
        for (boolean flag = false; flag = !flag; n--){
            for (int i = 1; i < n; i++){
                if (arr[i-1] > arr[i]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    flag = false;
                }
            }
        }
    }

    private void quickSort(int[] arr, int i , int j){
        if (i < j) return;
        int left = i;
        int right = j;
        int target = i;
        while(left < right){
            while(arr[target] < arr[left] && left < right) right--;
            while(arr[left] < arr[target] && left < right) left++;

            while(right > left){
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }

        arr[i] = arr[left];
        arr[left] = arr[target];

        quickSort(arr, i, left);
        quickSort(arr, left+1, j);
    }
}
