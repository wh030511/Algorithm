package exam.jd;


import org.junit.Test;

import java.util.Scanner;

/**
 * @Author WuHao
 * @Create 2020-08-06-18:38
 * 求以下数列的和：
 *
 * f(n)=1/5-1/10+1/15-1/20+1/25-......+1/(5*(2*n-1))-1/(5*2*n)。
 *
 * result: ac
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double res = 0;
        for (int i = 1; i <= 2*n; i++) {
            res += Math.pow(-1, i-1) * 1.0/i;
        }
        res *= 1.0/5.0;
        String value = String.format("%.4f", res);
        System.out.println(value);
    }

    @Test
    public void test() {
        System.out.println(1.0/5 - 1.0/10 + 1.0/15);
    }
}
