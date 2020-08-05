package exam.meituan;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-03-12-18:10
 * 小美曾经有一个特殊的数组，这个数组的长度为n。但是她在打恐怖游戏的时候被吓得忘记了这个数组长什么样了。不过她还记得这个数组满足一些条件。
 * <p>
 * 首先这个数组的每个数的范围都在L和R之间。包括端点。
 * <p>
 * 除此之外，这个数组满足数组中的所有元素的和是k的倍数。
 * <p>
 * 但是这样的数组太多了，小美想知道有多少个这样的数组。你只需要告诉她在模1e9+7意义下的答案就行了
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int floor = n * l;
            int tail = n * r;
            int mod = floor % k;
            if(mod != 0){
                for(int i = floor / k + 1; i <= tail / k; i++){
                    int target = i * k;
                    count(n , l , r , target);
                }
            }
        }
    }

    private static int count(int n , int l ,int r , int target){
        int[] arr = new int[n];
        int sum = target - l * n;
        int[] dp = new int[n+1];
        return 0;
    }
}
