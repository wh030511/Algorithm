package offer;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:54
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int i = 0;
        for(i = numbers.length - 1;i > 0; i--){
            if(numbers[i] < numbers[i - 1]) break;
        }
        return numbers[i];
    }
}
