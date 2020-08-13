package exam.bilibili;

/**
 * @Author WuHao
 * @Create 2020-08-13 18:48
 *
 * 给出四个1-10的数字，通过加减乘除，得到24就算胜利
 *
 * result : ac
 */
public class Main {
    public boolean Game24Points (int[] arr) {
        return helper(arr, 3, 24);
    }

    private boolean helper(int[] arr, int end, int target) {
        if (end == 0) {
            return arr[end] == target;
        }

        return helper(arr, end - 1, target - arr[end])
                || helper(arr, end - 1, target + arr[end])
                || helper(arr, end-1, target*arr[end])
                || (target % arr[end] == 0 && helper(arr, end-1, target / arr[end]));
    }
}
