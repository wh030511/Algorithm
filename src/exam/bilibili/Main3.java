package exam.bilibili;

/**
 * @Author WuHao
 * @Create 2020-08-13 19:33
 *
 * 面值1元、4元、16元、64元的硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元纸币购买了一件价值为N的商品，请问他最少会收到多少硬币
 *
 * result: ac
 */
public class Main3 {
    public int GetCoinCount (int N) {
        int value = 1024 - N; // 要找的钱
        int res = 0;
        res += value / 64;
        value = value % 64;
        res += value / 16;
        value %= 16;
        res += value / 4;
        value %= 4;
        res += value;

        return res;
    }
}
